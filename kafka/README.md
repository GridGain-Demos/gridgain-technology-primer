# GridGain Digital Integration Hub
GridGain Digital Integration Hub is intended to be used as an example of how to implement a Digital Integration Hub connecting to various 3rd party data sources.

This project extends the core Technology Primer

## Setup Databases

*This has only been tested on Mac with Apple Silicon, your milage may vary ;-)*

1. Start DB's in Docker & Load Data
	
	1. MySql
	
	```bash
	cd mysql
	./docker.sh
	```
	2. Postgres

	```bash
	cd postgres
	./docker.sh
	```
	
	1. Cassandra

	```bash
	cd cassandra
	./docker.sh
	```
	
	1. MongoDB
	

	```bash
	cd mongodb
	./docker.sh
	```
	
	1. Oracle
	
	```bash
	cd oracle
	./docker.sh
	```

2. Run the class com.gridgain.dih.replicate.GenerateAll

	This will generate POJOs, CacheConfiguration and IgniteClientHelper classes in com.gridgain.dih.gen package
	This will also generate an ApiServer class and OpenApi definition which provides CRUD operations for each of the tables.

## Setup Kafka Services

3. Configure License

	In order to use the Kafka Connect services you will need to run either GridGain Enterprise or Ultimate Editions and hence require a license.
	
	You can choose the edition by selecting the relevant Maven profile & update the LICENSE_URL in com.gridgain.dih.app.DemoConfiguration.

3. Deploy Kafka to Docker

	```bash
	docker-compose -f docker-compose.yml up
	```

Kafka Control Center is enabled so you can monitor Kafka cluster with http://localhost:9021/

## Setup Kafka Connect
4. Download binary package

    ```sh
    curl -O https://packages.confluent.io/archive/7.5/confluent-7.5.0.tar.gz
    ```
5. Extract contents

    ```sh
    tar -xvzf confluent-7.5.0.tar.gz
    ```
6. Set Environment
    
    ```sh
    export CONFLUENT_HOME=.../confluent-7.5.0
    export PATH=$PATH:$CONFLUENT_HOME/bin
    ```
7. Install GridGain Kafka Connector
    
    ```bash
    confluent-hub install gridgain/gridgain-kafka-connect:8.9.5
    The component can be installed in any of the following Confluent Platform installations:
     1. .../confluent-7.5.0 (based on $CONFLUENT_HOME)
     2. .../confluent-7.5.0 (found in the current directory)    
     3. .../confluent-7.5.0 (where this tool is installed)

    Choose one of these to continue the installation (1-3): 1

    Do you want to install this into .../confluent-7.5.0/share/confluent-hub-components? (yN) y

    You are about to install \'gridgain-kafka-connect\' from GridGain Systems, Inc., as published on Confluent Hub. 

    Do you want to continue? (yN) y

    Downloading component Kafka Connect GridGain 8.9.5, provided by GridGain Systems, Inc. from Confluent Hub and installing into .../confluent-7.5.0/share/confluent-hub-components 
    Detected Worker\'s configs:

      1. Standard: .../confluent-7.5.0/etc/kafka/connect-distributed.properties 
      2. Standard: .../confluent-7.5.0/etc/kafka/connect-standalone.properties 
      3. Standard: .../confluent-7.5.0/etc/schema-registry/connect-avro-distributed.properties 
      4. Standard: .../confluent-7.5.0/etc/schema-registry/connect-avro-standalone.properties 

    Do you want to update all detected configs? (yN) y

    Adding installation directory to plugin path in the following files: 
    .../confluent-7.5.0/etc/kafka/connect-distributed.properties 
    .../confluent-7.5.0/etc/kafka/connect-standalone.properties 
    .../confluent-7.5.0/etc/schema-registry/connect-avro-distributed.properties 
    .../confluent-7.5.0/etc/schema-registry/connect-avro-standalone.properties 

    Completed 

    ```

9. Start a server node

	```bash
	com.gridgain.dih.app.IgniteServer
	```

10. Run the Kafka data generator

	```bash
	com.gridgain.dih.kafka.KafkaCsvStockTicker
	```
	
11. Start the connector with GridGain connector enabled

	```bash
	export _JAVA_OPTIONS="-Djava.net.preferIPv4Stack=true"
	connect-standalone etc/kafka/connect-standalone.properties ~/git/gridgain-dih/kafka/gridgain-kafka-connect-sink.properties
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
