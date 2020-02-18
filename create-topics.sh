#!/usr/bin/env bash
set -e

docker-compose exec -T kafka0 kafka-topics --create --bootstrap-server kafka0:9092 --replication-factor 1 --partitions 4 --topic 'person-topic.DLT'
docker-compose exec -T kafka0 kafka-topics --create --bootstrap-server kafka0:9092 --replication-factor 1 --partitions 4 --topic 'person-topic'
docker-compose exec -T kafka0 kafka-topics --create --bootstrap-server kafka0:9092 --replication-factor 1 --partitions 4 --topic 'simple-topic'
docker-compose exec -T kafka0 kafka-topics --create --bootstrap-server kafka0:9092 --replication-factor 1 --partitions 4 --topic 'simple-topic.DLT'
