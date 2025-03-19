## Running Distributed Compute Tasks

Run `org.gridgain.app.ComputeApp` that uses Apache Ignite compute capabilities for the calculation of top-5 paying customers.
The compute task executes on every cluster node. It iterates through local records and responds to the application that 
merges partial results.

1. In the earlier step of building the project, you can observe 2 jars being built in the libs folder of the project. We will now work with the apps.jar in this section.

2. Run the app in the terminal:
    <pre><code>java -cp libs/apps.jar:libs/core.jar org.gridgain.app.ComputeApp</code></pre>
    
You can see the overall result i.e. the top 5 highest paying customers on the same terminal (observe that some computations also be happened on this terminal locally and then the cumulative results are shown):

<img width="827" alt="image" src="https://github.com/user-attachments/assets/4ed0cbfd-64fe-4ada-8ffb-3db115b28ff7" />

On the dashboard, you can see the thick client count goes from 0 to 1. Note that the thin client count 1 is the SQLLine client connected to the cluster.

<img width="471" alt="image" src="https://github.com/user-attachments/assets/9852f434-144b-45dd-971f-6e6ab0102855" />


You can see the compute tasks under the "Compute" section of the portal.

![image](https://github.com/user-attachments/assets/1cffb986-28e3-4205-a73c-af6b29cea264)


3. Check the logs of the `ServerStartup` processes (your GridGain server nodes) to see that the calculation
was executed across the cluster.
<img width="853" alt="image" src="https://github.com/user-attachments/assets/f2632a98-33be-4b92-b84e-5d62132613ac" />


You can notice that the computation has happened on the server nodes.

<img width="894" alt="image" src="https://github.com/user-attachments/assets/53159ebd-cea2-4180-802a-59cbe4b3d700" />



#### Modify the computation logic: 

1. Update the logic to return top-10 paying customers (Hint: Modify the variable `customersCount` value in `ComputeApp.java`).

2. Re-build an executable JAR with the applications' classes (or just start the app with IntelliJ IDEA or Eclipse):
    <pre><code>mvn clean package </code></pre>
    
3. Run the app again:
    <pre><code>java -cp libs/apps.jar:libs/core.jar org.gridgain.app.ComputeApp</code></pre>
    
Observe the terminals where server nodes are running as well as the one where client node is running.


Task for self-exploration: Try the same exercise by making this third node as a client node and observe which computations happen on which nodes. For being able to call `setClientApp(true`, pass `true` while creating a new instance of AppConfiguration in the constructor of ComputeApp class, (Currently, no parameter has been passed, which ultimately leads to `setClientApp(false)`).

## Code Deployment on Nebula
If you are using GridGain Nebula for spinning up GridGain cluster, or Nebula just for Control Center, you can use the Code Deployment from the UI. Upload the `apps.jar` and deploy it. 

<img width="1483" alt="image" src="https://github.com/user-attachments/assets/e5432685-5079-4ac5-ae0d-e667f7486b61" />



Next Step:[Running SQL Queries on GridGain Data](SQLqueries.md)

Back to the [Main Page](../README.md/#step-by-step-guide)
