## Running SQL Queries

GridGain supports SQL for data processing including distributed joins, grouping and sorting. In this section, you're 
going to run basic SQL operations as well as more advanced ones.

### Querying Single Table

1. Go to the [Queries Screen](https://www.gridgain.com/docs/control-center/latest/querying) of GridGain Nebula.
 
2. Run the following query to find top-20 longest tracks in genres other than Opera, Classical, Comedy, Drama, TV shows, Sci-fi. We can use `IN` clause to specify genreIds. In this case, we want to exclude anything whose genreId is 17 or more.

    ```sql
    SELECT trackid, name, MAX(milliseconds / (1000 * 60)) as duration FROM track
    WHERE genreId < 17
    GROUP BY trackid, name ORDER BY duration DESC LIMIT 20;
    ```
 #### Understanding Query Execution
 
 For complex queries, optimizing queries significantly improves the performance. To be able to optimize any query, you will need to understand the execution strategy. Add `EXPLAIN` before a query and execute it to see the plan.
 Distributed queries are executed in a map-reduce manner. In the map phase, the query is executed on each node holding relevant data, and in the reduce phase, the results are aggregated and processed on the coordinating node—the node that initiated the query. 
 
 ![image](https://github.com/user-attachments/assets/be9083c3-faf7-476b-b35d-4d6686a0013a)

 #### Query Statistics

 You can see the Explain Plan for a query that you have already run from the Query Statistics page. Here you can also notice performance of your query.

 <img width="1476" alt="image" src="https://github.com/user-attachments/assets/956befc6-4034-437b-83d1-1b2170fe77af" />

Next Step:[Optimizing SQL Joins by Colocating Data](Affinity.md)

Back to [Main Page](../README.md)