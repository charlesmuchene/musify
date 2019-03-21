*** Batch read .csv file
*** Retrieve data from https://api-v2.soundcloud.com/featured_tracks/front?client_id=ccneGvN2nRqzObcQIySRAOqGH61n58zg&limit=20&offset=0&linked_partitioning=1&app_version=1552999161&app_locale=en 

* Use queue to transfer the data to insert into system

=== from .csv

- Start activemq and RabbitMQ
	C:\soft\apache-activemq-5.15.8-bin\apache-activemq-5.15.8\bin>activemq start
	AMQP - RabbitMQ : Program Windows icon -> RabbitMQ service -> start

- Run batch manually to import data to RabitMQ: 
	/csvcollector/src/main/java/dev/cstv/main/Main.java

- Run data BUS - ESB
	/musify/src/main/java/dev/cstv/musify/main/SongCollectorGatewayMain.java

- Run listener to retrieve data from data BUS and insert into system
	/musify/src/main/java/dev/cstv/musify/main/SongCollectorListenerMain.java
	
=== from soundcloud.com
- Start activemq and RabbitMQ
- Run /csvcollector/src/main/java/dev/cstv/main/SoundCloudMain.java
- Run data BUS - ESB
	/musify/src/main/java/dev/cstv/musify/main/SongCollectorGatewayMain.java

- Run listener to retrieve data from data BUS and insert into system
	/musify/src/main/java/dev/cstv/musify/main/SongCollectorListenerMain.java

