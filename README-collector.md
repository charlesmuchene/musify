Batch read .csv file 
Use queue to transfer the data to insert into system

- Start activemq and RabbitMQ
	C:\soft\apache-activemq-5.15.8-bin\apache-activemq-5.15.8\bin>activemq start
	AMQP - RabbitMQ : Program Windows icon -> RabbitMQ service -> start

- Run batch manually to import data to RabitMQ: 
	/csvcollector/src/main/java/dev/cstv/main/Main.java

- Run the to come up to data BUS - ESB
	/musify/src/main/java/dev/cstv/musify/main/SongCollectorGatewayMain.java

- Run listener to retrieve data from data BUS and insert into system
	/musify/src/main/java/dev/cstv/musify/main/SongCollectorListenerMain.java