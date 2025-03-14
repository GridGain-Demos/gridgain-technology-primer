## Running Distributed Compute Tasks

Run `org.gridgain.app.ComputeApp` that uses Apache Ignite compute capabilities for the calculation of top-5 paying customers.
The compute task executes on every cluster node. It iterates through local records and responds to the application that 
merges partial results.

1. In the earlier step of building the project, you can observe 2 jars being built in the libs folder of the project. We will now work with the apps.jar in this section.

2. Run the app in the terminal:
    <pre><code>java -cp libs/apps.jar org.gridgain.app.ComputeApp</code></pre>
    
You can see the overall result i.e. the top 5 highest paying customers on the same terminal (observe that some computations also be happened on this terminal locally and then the cumulative results are shown):
<img width="819" alt="image" src="https://github.com/user-attachments/assets/3863c933-d888-4ede-aedc-9e8828efef5b" />

You can see the compute tasks under the "Compute" section of the portal.

![image](https://github.com/user-attachments/assets/1cffb986-28e3-4205-a73c-af6b29cea264)


3. Check the logs of the `ServerStartup` processes (your GridGain server nodes) to see that the calculation
was executed across the cluster.
<img width="800" alt="image" src="https://github.com/user-attachments/assets/dbb96871-751d-471e-84c4-1dcaa802fd6d" />

You can notice that the computation has happened on all the nodes.

<img width="904" alt="image" src="https://github.com/user-attachments/assets/c9f6efcf-6083-4e0c-87c3-172c6dbc8530" />

#### Modify the computation logic: 

1. Update the logic to return top-10 paying customers (Hint: Modify the variable `customersCount` value in `ComputeApp.java`).

2. Re-build an executable JAR with the applications' classes (or just start the app with IntelliJ IDEA or Eclipse):
    <pre><code>mvn clean package </code></pre>
    
3. Run the app again:
    <pre><code>java -cp libs/apps.jar org.gridgain.app.ComputeApp</code></pre>
    
<img width="818" alt="image" src="https://github.com/user-attachments/assets/234e32c7-9c4d-49a5-8738-a9bd151e206a" />