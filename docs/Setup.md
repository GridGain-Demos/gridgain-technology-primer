 
## Setting Up Environment
We will be spinning up a 2-node GridGain Community Edition cluster locally for this workshop. Note that we do not not recommend this cluster setup for production purposes. [Here](https://www.gridgain.com/docs/latest/installation-guide) are other ways of installing a GridGain cluster. You may even spin up a fully-managed cloud cluster on [GridGain Nebula](https://portal.gridgain.com/):
<img width="1411" alt="image" src="https://github.com/user-attachments/assets/67be946e-ef76-4ad4-9953-96ab1379593e" />


Install the following on your local machine:
* Java Developer Kit, version 8 or 11 and set JAVA_HOME
* Apache Maven 3.0 or later
* Your favorite IDE, such as IntelliJ IDEA, or Eclipse, or a simple text editor.

This project will also work with Java 17, but additional options need
to be specified on the command-line. You can use `@src/main/resources/j17.params` argument
after `java` command so that the parameters from the j17.params file are picked up while executing the command.

See the [documentation](https://ignite.apache.org/docs/latest/setup#running-ignite-with-java-11-or-later)
for more details. The steps that follow assume Java 8 or 11.

## Clone The Project

1. Clone the training project with Git or download it as an archive:
    <pre><code>git clone https://github.com/GridGain-Demos/gridgain-technology-primer.git</code></pre>
    
2. Optional- open the project in your favourite IDE such as IntelliJ or Eclipse, or just use a simple text editor
and command-line instructions prepared for all the samples.    

## Starting GridGain Cluster

You will not have to run GridGain separately because we will be starting the GridGain nodes(and cluster) from the application itself. This is called the "embedded mode". Start a two-node GridGain cluster:

1. Open a terminal window and navigate to the root directory of this project.

2. Use Maven to create a core executable JAR with all the dependencies (Note, build the JAR even if you plan to
start the sample code with IntelliJ IDEA or Eclipse. The JAR is used by other tools throughout the class):
    <pre><code>mvn clean package</code></pre>
    
   If you see build errors, it may be because a firewall or proxy server is blocking access to
[GridGain's External Maven Repo](https://www.gridgainsystems.com/nexus/content/repositories/external) which is used
to download the module that connects to GridGain Nebula.
3. Start the first cluster node (or just start the app with IntelliJ IDEA or Eclipse):
    <pre><code>java -cp libs/core.jar org/gridgain/server/IgniteServer</code></pre>

4. Open another terminal window and start the second node:
    <pre><code>java -cp libs/core.jar org/gridgain/server/IgniteServer</code></pre>

Both nodes auto-discover each other and you'll have a two-nodes cluster ready for exercises. On both the terminals, you will notice a token being printed. We need this token in the next step.
<pre>>>> +---------------------------------------------------------------------------------------------------+
>>> | If you are already using Control Center, you can add the cluster manually using a one-time token: |
</pre>


Next Step:[Connect to GridGain Control Center](ControlCenter.md)

Back to the [Main Page](../README.md/#step-by-step-guide)