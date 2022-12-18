# kafka-project

This is a beginner project to kafka with spring boot.

This is a multi maven module application compose of two modules : 
* kafka producer microservice : consume a stream data from this api : https://stream.wikimedia.org/v2/stream/recentchange and publish event stream data to kafka server.
* kafka consumer microservice : consume the data from kafka server and write it back to a mysql database.

## Run the project 

* Run zookeeper    : .\bin\windows\zookeeper-server-start.bat config\zookeeper.properties
* Run kafka server : .\bin\windows\kafka-server-start.bat config\server.properties
* Create a mysql database, eg: "wikimedia".
* Configure application.properties inside kafka-consumer-database microservice.
* Run the consumer module,and producer module.
