# GridGain Acceleration Workshop: Concepts to Practical Mastery

Welcome to the GridGain Acceleration Workshop! This repository provides a practical introduction to GridGain, designed to help you explore its potential for enhancing application performance and scalability. Our goal is to demonstrate how GridGain can be effectively utilized within your project. This workshop, structured for both guided demonstrations and independent exploration, will walk you through key concepts and hands-on examples, allowing you to experience and apply GridGain's capabilities.
 
## Setting Up Environment

* Java Developer Kit, version 8 or 11
* Apache Maven 3.0 or later
* Your favorite IDE, such as IntelliJ IDEA, or Eclipse, or a simple text editor.

This project will also work with Java 17, but additional options need
to be specified on the command-line. You can use `@src/main/resources/j17.params` argument
after `java` command so that the parameters from the j17.params file are picked up while executing the command.

See the [Ignite documentation](https://ignite.apache.org/docs/latest/setup#running-ignite-with-java-11-or-later)
for more details. The steps that follow assume Java 8 or 11.

## Clone The Project

1. Clone the training project with Git or download it as an archive:
    ```bash
    git clone https://github.com/GridGain-Demos/gridgain-technology-primer.git
    ```

2. Optional- open the project in your favourite IDE such as IntelliJ or Eclipse, or just use a simple text editor
and command-line instructions prepared for all the samples.    

## Starting GridGain Cluster

You will not have to run GridGain separately because we will be starting the GridGain nodes(and cluster) from the application itself. This is called the "embedded mode". Start a two-node GridGain cluster:

1. Open a terminal window and navigate to the root directory of this project.

2. Use Maven to create a core executable JAR with all the dependencies (Note, build the JAR even if you plan to
start the sample code with IntelliJ IDEA or Eclipse. The JAR is used by other tools throughout the class):
    ```bash
    mvn clean package
    ```
   If you see build errors, it may be because a firewall or proxy server is blocking access to
[GridGain's External Maven Repo](https://www.gridgainsystems.com/nexus/content/repositories/external) which is used
to download the module that connects to GridGain Nebula.
3. Start the first cluster node (or just start the app with IntelliJ IDEA or Eclipse):
    ```bash
    java -cp libs/core.jar org/gridgain/server/IgniteServer
    ```

4. Open another terminal window and start the second node:
    ```bash
    java -cp libs/core.jar org/gridgain/server/IgniteServer
    ```

Both nodes auto-discover each other and you'll have a two-nodes cluster ready for exercises.
 
## Connecting to GridGain Nebula
You use [GridGain Nebula](https://portal.gridgain.com) throughout the course to see how GridGain distributes 
records, to execute and optimize SQL queries, and to monitor the state of the cluster.

1. Go to [https://portal.gridgain.com](https://portal.gridgain.com).

2. Create an account to sign in into GridGain Nebula.

3. Select "Attach GridGain" option, which opens a modal panel to enter connection token of the GridGain cluster. ![image](https://github.com/user-attachments/assets/c9b9406c-3d82-4d65-88a4-14090f22cdab)

Just in case you get error regarding connection token being invalid or expired, generate a new token for the cluster as instructed below. The default token expires in 5 minutes after the cluster startup time.

* Open a terminal window and navigate to the root directory of this project.
    
* Generate the token (the `ManagementCommandHandler` is the tool used by the 
    [management.sh|bat script](https://www.gridgain.com/docs/control-center/latest/clusters#generating-a-token) of the 
    Ignite Agent distribution package, you just call it directly with this training to skip extra downloads): 
    
  ```bash
  java -cp libs/core.jar org.gridgain.control.agent.commandline.ManagementCommandHandler --token
  ```
     
More information on [Registering the cluster](https://www.gridgain.com/docs/control-center/latest/clusters#adding-clusters) with GridGain Nebula 
using the token.

## Creating Media Store Schema and Loading Data

Now you need to create a Media Store schema and load the cluster with sample data. Use SQLLine tool to achieve that:

1. Open a terminal window and navigate to the root directory of this project.
   
2. We will use the executable JAR created earlier and launch a SQLLine process:
    ```bash
    java -cp libs/core.jar sqlline.SqlLine
    ```
   
3. Connect to the cluster:
    ```bash
    !connect jdbc:ignite:thin://127.0.0.1/ ignite ignite
    ```

4. Create and load the Media Store database:
    ```bash
    !run sql/media_store_create.sql
    ```
    ```bash
    !run sql/media_store_populate.sql
    ```

Keep the connection open as you'll use it for following exercises.

## Data Partitioning - Checking Data Distribution

Data partitioning is a method of subdividing large sets of data into smaller chunks and distributing them between all server nodes. With the Media Store database loaded, you can check how GridGain distributed the records within the cluster:

1. Open the [Caches Screen](https://www.gridgain.com/docs/control-center/latest/caches#partition-distribution) of 
GridGain Nebula. You will see the tables created from SQLLine on the Caches Screen.
<img width="1491" alt="image" src="https://github.com/user-attachments/assets/79006749-ea3a-4a99-9152-948d54862dc8" />

2. Select different caches and observe the number of primary keys.
<img width="1378" alt="image" src="https://github.com/user-attachments/assets/d4e2b7ae-087b-42c7-913f-b7fe57d645b3" />

You can verify the same on your SQLLine window.

<img width="600" alt="image" src="https://github.com/user-attachments/assets/24051781-0293-494b-8f14-bf57cbfc9755" />

3. Optional- scale out the cluster by the third node. You'll see that some partitions were rebalanced to the new node.
<img width="1376" alt="image" src="https://github.com/user-attachments/assets/7e3f172c-0537-4177-b061-288eb68bb969" />

## Running Distributed Compute Tasks

Run `org.gridgain.app.ComputeApp` that uses Apache Ignite compute capabilities for the calculation of top-5 paying customers.
The compute task executes on every cluster node. It iterates through local records and responds to the application that 
merges partial results.

1. In the earlier step of building the project, you can observe 2 jars being built in the libs folder of the project. We will now work with the apps.jar in this section.

2. Run the app in the terminal:
    ```bash
    java -cp libs/apps.jar org.gridgain.app.ComputeApp
    ```
You can see the overall result i.e. the top 5 highest paying customers on the same terminal (observe that some computations also be happened on this terminal locally and then the cumulative results are shown):
<img width="819" alt="image" src="https://github.com/user-attachments/assets/3863c933-d888-4ede-aedc-9e8828efef5b" />

3. Check the logs of the `ServerStartup` processes (your GridGain server nodes) to see that the calculation
was executed across the cluster.
<img width="800" alt="image" src="https://github.com/user-attachments/assets/dbb96871-751d-471e-84c4-1dcaa802fd6d" />

You can notice that the computation has happened on all the nodes.

<img width="904" alt="image" src="https://github.com/user-attachments/assets/c9f6efcf-6083-4e0c-87c3-172c6dbc8530" />

#### Modify the computation logic: 

1. Update the logic to return top-10 paying customers. (Hint: Modify the variable `customersCount` value in `ComputeApp.java`.

2. Re-build an executable JAR with the applications' classes (or just start the app with IntelliJ IDEA or Eclipse):
    ```bash
    mvn clean package 
    ```
3. Run the app again:
    ```bash
    java -cp libs/apps.jar org.gridgain.app.ComputeApp
    ```
<img width="818" alt="image" src="https://github.com/user-attachments/assets/234e32c7-9c4d-49a5-8738-a9bd151e206a" />


## Affinity Colocation - Optimizing Complex SQL Queries With JOINs

GridGain supports SQL for data processing including distributed joins, grouping and sorting. In this section, you're 
going to run basic SQL operations as well as more advanced ones.

### Querying Single Table

1. Go to the [Queries Screen](https://www.gridgain.com/docs/control-center/latest/querying) of GridGain Nebula.
 
2. Run the following query to find top-20 longest tracks:

    ```sql
    SELECT trackid, name, MAX(milliseconds / (1000 * 60)) as duration FROM track
    WHERE genreId < 17
    GROUP BY trackid, name ORDER BY duration DESC LIMIT 20;
    ```
### Joining Two Non-Colocated Tables

1. Modify the previous query by adding information about an author. You do this by doing a LEFT
JOIN with the `Artist` table:

    ```sql
    SELECT track.trackId, track.name as track_name, genre.name as genre, artist.name as artist,
   MAX(milliseconds / (1000 * 60)) as duration FROM track
   LEFT JOIN artist ON track.artistId = artist.artistId
   JOIN genre ON track.genreId = genre.genreId
   WHERE track.genreId < 17
   GROUP BY track.trackId, track.name, genre.name, artist.name ORDER BY duration DESC LIMIT 20;
   ```

    Once you run the query, you'll see that the `artist` column is blank for some records. That's because `Track` and 
    `Artist` tables are not colocated and the nodes don't have all data available locally during the join phase.
   <img width="1476" alt="image" src="https://github.com/user-attachments/assets/1da233e1-bef6-45a6-aa46-0d6980d79bde" />
    
3. Allow the non-colocated joins by enabling the `Allow non-colocated joins` checkbox on the GridGain Nebula screen. Run the query again to see a complete and correct result.
   <img width="1086" alt="image" src="https://github.com/user-attachments/assets/8d6bb24c-51db-4955-a91e-728483b13e04" />

### Joining Two Colocated Tables

The non-colocated joins used above come with a performance penalty, i.e., if the nodes are shuffling large data sets
during the join phase, your performance will be impacted. However, it's possible to colocate `Track` and `Artist` tables, and
avoid the usage of the non-colocated joins:

1. Search for the `CREATE TABLE Track` command in the `media_store_create.sql` file.

2. Replace `PRIMARY KEY (TrackId)` with `PRIMARY KEY (TrackId, ArtistId)`.

3. Colocate Tracks with Artist by adding `affinityKey=ArtistId` to the parameters list of the `WITH ...` operator.

4. The above mentioned changes are available in the file `media_store_create_colocated.sql`. We will drop all the tables from SQLLine terminal(earlier used for creating and populating the cache). Stop the running GridGain server(s). Remove the `.txt` extension of TrackKey.java.txt file so that now you have TrackKey.java in your org.gridgain.model folder.

    * Build the project:
        ```bash
        mvn clean package
        ```
   * Start the server(s):
        ```bash
        java -cp libs/core.jar org/gridgain/server/IgniteServer
        ``` 
    * Launch SQLine from a terminal window (in case you exited the earlier one):
        ```bash
        java -cp libs/core.jar sqlline.SqlLine
        ```
   * Connect to the cluster:
        ```bash
        !connect jdbc:ignite:thin://127.0.0.1/ ignite ignite
        ```       
    * Drop the existing tables from SQLLine. Confirm if it asks you whether you want to delete all the tables.
        ```bash
        !dropall
        ```
    * Create the tables using the script. This time the script contains affinity key, which mentions what data should reside on the same node.
        ```bash
       !run sql/media_store_create_colocated.sql
       ```
    * Load the Media Store database:
        ```bash
        !run sql/media_store_populate.sql
        ```
        
5. In GridGain Nebula, run that query once again(without selecting the checkbox and you'll see that all the `artist` columns are filled in because now all the Tracks are stored together with their Artists on the same cluster node.
<img width="1061" alt="image" src="https://github.com/user-attachments/assets/af1ae8bf-76bc-4ff7-9287-a25d736a4f57" />


We got an overview of how data is stored in GridGain cluster(distributed across the nodes and partitioned), how we can enforce records of more than 1 caches to reside on the same node(using affinity key; and the affinity key should be a part of the primary key), how we can perform colocated joins and how can we distribute a compute tasks across all the nodes.

