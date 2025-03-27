## 3. Creating Media Store Schema and Loading Data

Let's step into the world of digital music! In this workshop, we'll use a 'Media Store' database, a simulated digital tracks library, to explore real-world data scenarios. Our goal is to see how GridGain distributes data, write SQL queries and later optimize them. We'll focus on familiar entities like artists, tracks, customers and invoices, allowing us to dive straight into data distribution and query logic, bypassing the complexities of schema design and data loading. By the end of this workshop, you'll be ready to analyze your own business datasets and answer critical questions.

Use SQLLine tool to load the data in GridGain:

1. Open a terminal window and navigate to the root directory of this project.
   
2. We will use the executable JAR created earlier and launch a SQLLine process from terminal:
 
    <pre><code>java -cp core/libs/core.jar sqlline.SqlLine</code></pre>
    You will see the `sqlline` prompt on the terminal.
   
3. Connect to the cluster from this sqlline prompt:
   <pre><code>!connect jdbc:ignite:thin://127.0.0.1/ ignite ignite</code></pre>
   You will be connected to your GridGain cluster using the jdbc thin client.

4. Create and load the Media Store data on your GridGain cluster from the thin client:
    <pre><code>!run core/sql/media_store_create.sql</code></pre>

   You will notice that the script is getting executed and tables are getting created, a part of which looks like:
   <img width="757" alt="image" src="https://github.com/user-attachments/assets/49641f13-d126-4443-99bd-2047ae2eaf8f" />

    <pre><code>!run core/sql/media_store_populate.sql</code></pre>
   
   You will notice many insert statements executing; the end of which looks as follows:
   <img width="761" alt="image" src="https://github.com/user-attachments/assets/063b9413-4a5d-43c7-9796-dfb684574876" />

Keep the connection open, as you will use it for the upcoming exercises.
> [!note]
> - __Cache__ - Cache is a high-speed data storage layer. It is a collection of key-value pairs that can be accessed through the key-value API.
> - __Table__ - Table in GridGain corresponds to the notion of tables in traditional RDBMSs with some additional criteria; for example, each SQL table must have a primary key. SQL tables support traditional SQL syntax. Tables and caches are like two views of the same data

> [!important]
> **Checkpoint:** Running `!tables` command on this same SQLLine terminal should list many tables in system-level schema and script-created tables(Album, Artist, Customer, Employee, Genre, Invoice, InvoiceLine, MediaType, PlayList, PlayListTrack, Track) under PUBLIC schema.

Next Step: [Observe Data Distribution](PartitionedData.md)

Back to [Main Page](../README.md/#step-by-step-guide)
