## Connect to GridGain Control-Center
We will use [GridGain Nebula](https://portal.gridgain.com) Control Center throughout this course to see how GridGain distributes 
records, to execute and optimize SQL queries, and to monitor the state of the cluster. If you want to run Control-Center on-prem, you will need its license. [Contact GridGain](https://www.gridgain.com/contact) for the same.

1. Go to [https://portal.gridgain.com](https://portal.gridgain.com).

2. Create an account to sign in into GridGain Nebula.

3. Select "Attach GridGain" option, which opens a modal panel to enter the connection token(which got displayed on the terminal when you started the server) of the GridGain cluster.

![image](https://github.com/user-attachments/assets/c9b9406c-3d82-4d65-88a4-14090f22cdab)

Just in case you get error regarding connection token being invalid or expired, generate a new token for the cluster as instructed below. The default token expires in 5 minutes after the cluster startup time.

* Open a terminal window and navigate to the root directory of this project.
    
* Generate the token (the `ManagementCommandHandler` is the tool used by the 
    [management.sh|bat script](https://www.gridgain.com/docs/control-center/latest/clusters#generating-a-token) of the 
    Ignite Agent distribution package, you just call it directly with this training to skip extra downloads): 
    
  <pre><code>java -cp libs/core.jar org.gridgain.control.agent.commandline.ManagementCommandHandler --token</code></pre>
     
More information on [Registering the cluster](https://www.gridgain.com/docs/control-center/latest/clusters#adding-clusters) with GridGain Nebula 
using the token.

Next Step:[Load Data in GridGain Cluster](LoadData.md)

Back to the [Main Page](../README.md/#step-by-step-guide)