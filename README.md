# sprring-kafka-examples

A simple Spring Boot messaging examples projects using Kafka.

## Projects:

* **kafka-consumer-app:** A consumer for example topic
* **kafka-proucer-app:** A producer application

## Docker compose to run Kafka
This compose run a Kafka single broker cluster with one Zookeeper instance and Kafdrop application to monitor cluster.

### Service ports:
* **Zookeeper:** 2181
* **Kafka broker:** 9092
* **Kafdrop:** 9000

To acess Kafdrop web interface just open link: http://localhost:9000

## How to run Kafka examples (producer and consumer)

### Execute Kafka Cluster

```shell script
docker-compose up -d
```

### Execute Spring Boot applications
 
#### KafkaConsumerApplication
* Execute **KafkaConsumerApplication** on project kafka-consumer-app to start the consumer.\
* Start three KafkaConsumerApplication instances to consume three partitions in parallel.\
* See the messages on console output for each instance.

#### KafkaProducerApplication
* Execute **KafkaProducerApplication** on project kafka-producer-app to start sending messages using this endpoints:

To produce 100 messages for simple-topic
http://localhost:8080/api/producer/simple-topic?start=1&end=100

To produce 100 messages for person-topic
http://localhost:8080/api/producer/person-topic?start=1&end=100

Use the start and end parameters as message IDs to track on producer and consumer.

