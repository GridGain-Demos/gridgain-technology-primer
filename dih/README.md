# GridGain Digital Integration Hub
GridGain Digital Integration Hub is intended to be used as an example of how to implement a Digital Integration Hub connecting to various 3rd party data sources.

This project extends the core Technology Primer

## Setup Databases

*This has only been tested on Mac with Apple Silicon, your milage may vary ;-)*

1. Start DB's in Docker & Load Data

	a. Using Docker Compose

	```bash
	docker compose -f docker-compose.yml up --detach
	dataload.sh
	```

2. Selectively
	
	a. MySql
	
	```bash
	cd mysql
	./docker.sh
	```
	b. Postgres

	```bash
	cd postgres
	./docker.sh
	```
	
	c. Cassandra

	```bash
	cd cassandra
	./docker.sh
	```
	
	d. MongoDB
	

	```bash
	cd mongodb
	./docker.sh
	```

2. Run the class

	```bash
	com.gridgain.dih.replicate.GenerateAll
	```

	This will generate POJOs, CacheConfiguration and IgniteClientHelper classes in com.gridgain.dih.gen package
	This will also generate an ApiServer class and OpenApi definition which provides CRUD operations for each of the tables.

9. Start a server node (from the core Module)

	```bash
	com.gridgain.server.IgniteServer
	```

12. Start the Client, this will load all the data from all the 3rd party data sources

	```bash
	com.gridgain.dih.gen.app.IgniteClientHelper
	```
	
13. Start the REST API server

	GET, POST & DELETE methods have been created for each table which takes a parameter of the object id, POST method does a put to the cache taking the body as Json of the object

	```bash
	com.gridgain.dih.gen.app.ApiServer
	```
