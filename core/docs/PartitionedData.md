## 4. Data Partitioning - Checking Data Distribution

Data partitioning is a method of subdividing large sets of data into smaller chunks and distributing them between all server nodes. With the Media Store database loaded, you can check how GridGain distributed the records within the cluster:

1. Open the [Caches Screen](https://www.gridgain.com/docs/control-center/latest/caches#partition-distribution) of 
GridGain Nebula. You will see the tables created from SQLLine on the Caches Screen.
<img width="1491" alt="image" src="https://github.com/user-attachments/assets/79006749-ea3a-4a99-9152-948d54862dc8" />

> [!tip]
> We have provided the Employee table as an additional resource for you to explore. The steps in our workshop do not require this table, so feel free to experiment with it.

> [!note]
> You will notice a couple of tables showing `Replicated` and rest of the tables showing `Partitioned` under the Mode column. Did we specify which cache should be of which type and how many backups are to be set? Yes. We have specified that in the `create table` definition of respective caches. e.g. Artist cache has `WITH "template=partitioned, backups=1 ..."` while Genre has `WITH "template=replicated ..."` in their respective definitions.
> - In **Replicated Cache Mode**, whole data is replicated to every node of the cluster. This mode provides the high availability of data.
> - In **Partitioned Cache Mode**, the data is split between the partitions across all server nodes. This mode is the most scalable; as the more nodes you have, the more data you can store.
 

2. Select different caches and observe the number of primary keys.
<img width="1378" alt="image" src="https://github.com/user-attachments/assets/d4e2b7ae-087b-42c7-913f-b7fe57d645b3" />

You can verify the same on your SQLLine window.

<img width="600" alt="image" src="https://github.com/user-attachments/assets/24051781-0293-494b-8f14-bf57cbfc9755" />

3. Optional- scale out the cluster by the third node. You'll see that some partitions were rebalanced to the new node.
<img width="1376" alt="image" src="https://github.com/user-attachments/assets/7e3f172c-0537-4177-b061-288eb68bb969" />

> [!tip]
> In case of Partitioned cache, data is divided into 1024 partitions. Each node holds a subset of partitions, with primary and backup copies.

Here is a diagram that illustrates a 2-node GridGain cluster with two caches in partitioned mode, configured with 1 backup. It is provided as a simplified example to help understand how data is distributed and stored; and may not represent the actual distribution of data in a real cluster.

<div align=center>
 <img width=500 alt="Partitioned Cache" src="https://github.com/user-attachments/assets/d207bc3d-c1cc-4d3c-8bf0-2423b7101dc9">
</div>

Suppose our GridGain cluster has 3 nodes, and the partitioned cache (Cache_Partition in the diagram) is configured to have 1 backup. In this case, the distribution of primary and backup partitions would look as shown. For the replicated cache (Cache_Replicated in the diagram), every node in the cluster would hold a full copy of all the data. Here is an over-simplified view of the cluster:
<div align=center>
<img width=800 alt="Replicated Cache" src="https://github.com/user-attachments/assets/363c27b2-be97-4ff0-805b-421bc04e2345">
</div>

> [!note]
> In case of replicated cache, there are again partitions and the data is stored in the partitions. However, the request gets served by the nearest or the local node.

> [!important]
> **Checkpoint:** The Caches page on Control Center should list all the created tables. Running `select count(*)` command on any of the tables on SQLLine should show a non-zero count. You can also execute `Run scan query` by clicking on the ellipsis on any of the tables shown on the Caches page.

Next Step: [Distribute and Run Computation Task](ComputeTask.md)

Back to the [Main Page](../README.md/#step-by-step-guide)
