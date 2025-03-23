## Data Partitioning - Checking Data Distribution

Data partitioning is a method of subdividing large sets of data into smaller chunks and distributing them between all server nodes. With the Media Store database loaded, you can check how GridGain distributed the records within the cluster:

1. Open the [Caches Screen](https://www.gridgain.com/docs/control-center/latest/caches#partition-distribution) of 
GridGain Nebula. You will see the tables created from SQLLine on the Caches Screen.
<img width="1491" alt="image" src="https://github.com/user-attachments/assets/79006749-ea3a-4a99-9152-948d54862dc8" />


> [!note]
> You will notice a couple of tables showing `Replicated` and rest of the tables showing `Partitioned` under the Mode column.
> In **Replicated Cache Mode**, all the data (every partition) is replicated to every node in the cluster. This mode provides the high availability of data.
> In **Partitioned Cache Mode**, the data is split between the partitions across all server nodes. This mode is the most scalable; as the more nodes you have, the more data you can store.
 

2. Select different caches and observe the number of primary keys.
<img width="1378" alt="image" src="https://github.com/user-attachments/assets/d4e2b7ae-087b-42c7-913f-b7fe57d645b3" />

You can verify the same on your SQLLine window.

<img width="600" alt="image" src="https://github.com/user-attachments/assets/24051781-0293-494b-8f14-bf57cbfc9755" />

3. Optional- scale out the cluster by the third node. You'll see that some partitions were rebalanced to the new node.
<img width="1376" alt="image" src="https://github.com/user-attachments/assets/7e3f172c-0537-4177-b061-288eb68bb969" />

> [!important]
> **Checkpoint:** The Caches page on Control Center should list all the created tables. Running `select count(*)` command on any of the tables on SQLLine should show a non-zero count. You can also execute `Run scan query` by clicking on the ellipsis on any of the tables shown on the Caches page.

Next Step: [Distribute and Run Computation Task](ComputeTask.md)

Back to the [Main Page](../README.md/#step-by-step-guide)
