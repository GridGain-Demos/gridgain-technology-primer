## Creating Media Store Schema and Loading Data

Now you need to create a Media Store schema and load the cluster with sample data. Use SQLLine tool to achieve that:

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

Back to [Main Page](../README.md)