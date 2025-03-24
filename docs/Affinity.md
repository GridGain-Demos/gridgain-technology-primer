## 7. Optimizing Queries

Let us look at what happens when the tables we are joining in SQL query are residing on different server nodes.

### Joining Two Non-Colocated Tables

1. Modify the prior step query by adding information about an author. You do this by doing a LEFT
JOIN with the `Artist` table:

    ```sql
    SELECT track.trackId, track.name as track_name, genre.name as genre, artist.name as artist,
   MAX(milliseconds / (1000 * 60)) as duration FROM track
   LEFT JOIN artist ON track.artistId = artist.artistId
   JOIN genre ON track.genreId = genre.genreId
   WHERE track.genreId < 17
   GROUP BY track.trackId, track.name, genre.name, artist.name ORDER BY duration DESC LIMIT 20;
   ```

    Once you run the query, you'll see that the `artist` column is blank for some records. That's because `Track` and 
    `Artist` tables are not colocated and the nodes don't have all data available locally during the join phase.
   <img width="1476" alt="image" src="https://github.com/user-attachments/assets/1da233e1-bef6-45a6-aa46-0d6980d79bde" />

    
2. Allow the non-colocated joins by enabling the `Allow non-colocated joins` checkbox on the GridGain Nebula screen. Run the query again to see a complete and correct result.
   <img width="1086" alt="image" src="https://github.com/user-attachments/assets/8d6bb24c-51db-4955-a91e-728483b13e04" />

> [!tip]
> The same query is saved in sql file, which you can run from SQLLine as: `!run sql/top_20_longest_tracks_with_artists.sql` and see the result on SQLLine. You can observe the empty values against `ARTIST` column, same as you observed on UI after the first step.

> [!note]
> When data is colocated, it means that related data is stored on the same node in the cluster.

### Joining Two Colocated Tables

The non-colocated joins used above come with a performance penalty, i.e., if the nodes are shuffling large data sets
during the join phase, your performance will be impacted. However, it's possible to colocate `Track` and `Artist` tables, and
avoid the usage of the non-colocated joins:

1. Search for the `CREATE TABLE Track` command in the `media_store_create.sql` file.

2. Replace `PRIMARY KEY (TrackId)` with `PRIMARY KEY (TrackId, ArtistId)`.

3. Colocate Tracks with Artist by adding `affinityKey=ArtistId` to the parameters list of the `WITH ...` operator.

4. The above mentioned changes are available in the file `media_store_create_colocated.sql`. We will drop all the tables from SQLLine terminal(earlier used for creating and populating the cache). Stop the running GridGain server(s). Remove the `.txt` extension of TrackKey.java.txt file so that now you have TrackKey.java in your org.gridgain.model folder.

    * Build the project:
        <pre><code>mvn clean package</code></pre>
        
   * Start the server(s):
        <pre><code>java -cp libs/core.jar org/gridgain/server/IgniteServer</code></pre>
         
    * Launch SQLine from a terminal window (in case you exited the earlier one):
        <pre><code>java -cp libs/core.jar sqlline.SqlLine</code></pre>
        
   * Connect to the cluster:
        <pre><code>!connect jdbc:ignite:thin://127.0.0.1/ ignite ignite</code></pre>
               
    * Drop the existing tables from SQLLine. Confirm if it asks you whether you want to delete all the tables.
        <pre><code>!dropall</code></pre>
        
    * Create the tables using the script. This time the script contains affinity key, which mentions what data should reside on the same node.
        <pre><code>!run sql/media_store_create_colocated.sql</code></pre>
       
    * Load the Media Store database:
        <pre><code>!run sql/media_store_populate.sql</code></pre>
        
        
5. In GridGain Nebula, run that query once again(without selecting the checkbox and you'll see that all the `artist` columns are filled in because now all the Tracks are stored together with their Artists on the same cluster node.
<img width="1061" alt="image" src="https://github.com/user-attachments/assets/af1ae8bf-76bc-4ff7-9287-a25d736a4f57" />


Task for self-exploration: Compare the performance of non-colocated join query and its corresponding colocated join query.

Back to the [Main Page](../README.md#we-covered-the-basics)
