package com.antoniordo.kafka.producer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class SimpleTopicProducer {
    
    Logger logger = LoggerFactory.getLogger(SimpleTopicProducer.class);
    
    private KafkaTemplate<Object, Object> kafkaTemplate;
    
    public SimpleTopicProducer(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public void produce(int start, int end) {
        for (int sequential = start; sequential <= end; sequential++) {
            String message = String.format("example %d", sequential);
            kafkaTemplate.send("simple-topic", message);
            logger.info("Sent message: {}", message);
        }
    }
    
}
