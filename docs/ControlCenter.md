## Connect to GridGain Control-Center
We will use [GridGain Nebula](https://portal.gridgain.com) Control Center throughout this course to see how GridGain distributes 
records, to execute and optimize SQL queries, and to monitor the state of the cluster. If you want to run Control-Center on-prem, you will need its license. [Contact GridGain](https://www.gridgain.com/contact) for the same.

1. Go to [https://portal.gridgain.com](https://portal.gridgain.com).

2. Create an account to sign in into GridGain Nebula.

3. Select "Attach GridGain" option, which opens a modal panel to enter the connection token(which got displayed on the terminal when you started the server) of the GridGain cluster.
   
<div align="center">
<img width= 500 alt="Enter token" src="https://github.com/user-attachments/assets/c9b9406c-3d82-4d65-88a4-14090f22cdab" />
</div>

Just in case you get error regarding connection token being invalid or expired, generate a new token for the cluster as instructed below. The default token expires in 5 minutes after the cluster startup time.

* Open a terminal window and navigate to the root directory of this project.
    
* Generate the token (the `ManagementCommandHandler` is the tool used by the 
    [management.sh|bat script](https://www.gridgain.com/docs/control-center/latest/clusters#generating-a-token) of the 
    Ignite Agent distribution package). In this application, since the dependency is packaged, you can call it directly using the following command: 
    
  <pre><code>java -cp libs/core.jar org.gridgain.control.agent.commandline.ManagementCommandHandler --token</code></pre>

The correct and valid token will connect to your cluster and take you to the dashboard, show your cluster to be **Healthy** and "Nodes" section will show your server nodes.
<div align="center">
<img width="700" alt="image" src="https://github.com/user-attachments/assets/2fe10422-4cd6-42bd-8aac-08e255be44bb" />
</div>

> [!note]
> - __Coordinator Node__ - It is the node of the cluster that receives the distributed computing job, manages its execution, and reports the results to the client. It is a "special" server node that is responsible for certain administrative tasks and coordinating between the cluster nodes.
> - __GridGain Nebula__ - It is a cloud-native, fully-managed service for the Apache Ignite and GridGain platforms. You can spin up Ignite/GridGain cluster in Nebula. Or you can use Nebula Control Center, while running your Ignite/GridGain cluster locally or on public/private cloud.


> [!important]
> **Checkpoint:** You should see the Control Center dashboard and 2 nodes with `Online` status listed.

Next Step: [Load Data in GridGain Cluster](LoadData.md)

Back to the [Main Page](../README.md/#step-by-step-guide)
