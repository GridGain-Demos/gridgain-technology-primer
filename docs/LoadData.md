## Creating Media Store Schema and Loading Data

Let's step into the world of digital music! In this workshop, we'll use a 'Media Store' database, a simulated digital tracks library, to explore real-world data scenarios. Our goal is to see how GridGain distributes data, write SQL queries and later optimize them. We'll focus on familiar entities like artists, tracks, customers and invoices, allowing us to dive straight into data distribution and query logic, bypassing the complexities of schema design and data loading. By the end of this workshop, you'll be ready to analyze your own business datasets and answer critical questions.

Use SQLLine tool to load the data in GridGain:

1. Open a terminal window and navigate to the root directory of this project.
   
2. We will use the executable JAR created earlier and launch a SQLLine process:
 
    <pre><code>java -cp libs/core.jar sqlline.SqlLine</code></pre>
    
   
3. Connect to the cluster:
   <pre><code>!connect jdbc:ignite:thin://127.0.0.1/ ignite ignite</code></pre>


4. Create and load the Media Store database:
    <pre><code>!run sql/media_store_create.sql</code></pre>
    
    <pre><code>!run sql/media_store_populate.sql</code></pre>
   

Keep the connection open as you'll use it for following exercises.

Next Step:[Observe Data Distribution](PartitionedData.md)

Back to [Main Page](../README.md/#step-by-step-guide)
