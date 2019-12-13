# sprring-kafka-examples

A simple Spring Boot messaging examples projects using Kafka.

## Projects:

* **kafka-consumer-app:** A consumer for example topic
* **kafka-proucer-app:** A producer for example topic, produces one message per second

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

### Create example topic

```shell script
docker-compose exec -T kafka0 \
  kafka-topics --create --zookeeper zookeeper:2181 --topic example --replication-factor 1 --partitions 3
```

### Execute Spring Boot applications
 
#### KafkaConsumerApplication
* Execute **KafkaConsumerApplication** on project kafka-consumer-app to start the consumer.\
* Start three KafkaConsumerApplication instances to consume three partitions in parallel.\
* See the messages on console output for each instance.

#### KafkaProducerApplication
* Execute **KafkaProducerApplication** on project kafka-producer-app to start sending messages


