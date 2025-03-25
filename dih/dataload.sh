docker exec -it dih-data-sources-mongo-1 bash -c "mongoimport --db mflix --collection users --file /opt/data/users.json"
docker exec -it dih-data-sources-mongo-1 bash -c "mongoimport --db mflix --collection theaters --file /opt/data/theaters.json"
docker exec -it dih-data-sources-mongo-1 bash -c "mongoimport --db mflix --collection movies --file /opt/data/movies.json"
docker exec -it dih-data-sources-mongo-1 bash -c "mongoimport --db mflix --collection comments --file /opt/data/comments.json"

docker exec -it dih-data-sources-mysql-1 bash -c "/usr/bin/mysqladmin -uroot -ppassword create world"
docker exec -it dih-data-sources-mysql-1 bash -c "/usr/bin/mysql -uroot -ppassword world < /opt/data/world.sql"

docker exec -it dih-data-sources-postgres-1 bash -c "/usr/bin/psql -U postgres -f /opt/data/clubdata_ddl.sql"
docker exec -it dih-data-sources-postgres-1 bash -c "/usr/bin/psql -U postgres -f /opt/data/clubdata_data.sql"

docker exec -it dih-data-sources-cassandra-1 bash -c "/opt/cassandra/bin/cqlsh -f /opt/data/astronauts.cql"