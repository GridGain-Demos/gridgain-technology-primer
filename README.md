# GridGain Acceleration Workshop: Concepts to Practical Mastery

Welcome to the GridGain Acceleration Workshop! GridGain is an in-memory storage and computing platform that accelerates applications by providing in-memory distributed caching as well as processing, plus provides ACID transactions. This repository provides a practical introduction to GridGain, designed to help you explore its potential for enhancing application performance and scalability. Our goal is to demonstrate how GridGain can be effectively utilized within your project. This workshop, structured for both guided demonstrations and independent exploration, will walk you through key concepts and hands-on examples, allowing you to experience and apply GridGain's capabilities.

You might come across the names GridGain and Apache Ignite. The GridGain platform is built on Apache Ignite. The source code for Apache Ignite was originally contributed to the Apache Software Foundation by GridGain Systems. We will use the Community Edtion(CE) of GridGain platform in this workshop. The GridGain Community Edition is a source-available version of Apache Ignite which includes patches and updates not yet included in Ignite.

#### Introduction to Frequently Used Terminologies
* Server Node - A server node is the base computational and data storage unit in GridGain. Typically, you start a single server node per machine or container.
* GridGain Cluster - A cluster is a group of server nodes interconnected together in order to provide shared resources like RAM and CPU to your applications.
* Client Node - Client nodes are connection endpoints and gateways from the application layer to the cluster of GridGain server nodes. You always embed a client into your application code and execute required APIs. 
* Control Center - It is a management and monitoring tool for GridGain and Apache Ignite clusters. It features a graphical user interface that helps you perform administrative tasks and monitor your clusters.
* GridGain Nebula - It is a cloud-native, fully-managed service for the Apache Ignite and GridGain platforms. You can sping up Ignite/GridGain cluster in Nebula. Or you can use Nebula Control Center, while running your Ignite/GridGain cluster locally or on-prem.
* Caches - A cache is a high-speed data storage layer. It is a collection of key-value pairs that can be accessed through the key-value API.
* Table - A SQL table in GridGain corresponds to the notion of tables in traditional RDBMSs with some additional criteria; for example, each SQL table must have a primary key. SQL tables support traditional SQL syntax. Tables and caches are like two views of the same data.
* Data Partitioning - It is a method of subdividing large sets of data into smaller chunks and distributing them between all server nodes in a balanced manner.
* Partitioned Cache Mode - All partitions are split equally between all server nodes. This mode is the most scalable mode as more the nodes you have, the more data you can store.
* Replicated Cache Mode - All the data (every partition) is replicated to every node in the cluster. This mode provides the high availability of data. 
* Compute Task - The ComputeTask interface in GridGain provides fine-grained control over job distribution and custom fail-over logic, allowing developers to implement complex distributed algorithms, enabling massive parallel processing and efficient handling of large datasets. GridGain provides a simplified MapReduce API for it.

## Step-by-step Guide
Follow the instruction in each of these sections in the given order:
- [Project Setup and Cluster Creation](docs/Setup.md)
- [Connect to GridGain Control Center](docs/ControlCenter.md)
- [Load Data in GridGain Cluster](docs/LoadData.md)
- [Observe Data Distribution](docs/PartitionedData.md)
- [Distribute and Run Computation Task](docs/ComputeTask.md)
- [Running SQL Queries on GridGain Data](docs/SQLqueries.md)
- [Optimizing SQL Joins by Colocating Data](docs/Affinity.md)


We got an overview of how data is stored in GridGain cluster(distributed across the nodes and partitioned), how we can enforce records of more than 1 caches to reside on the same node(using affinity key; and the affinity key should be a part of the primary key), how we can perform colocated joins and how can we distribute a compute task across all the nodes.