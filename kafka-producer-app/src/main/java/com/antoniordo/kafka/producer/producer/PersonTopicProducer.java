package com.antoniordo.kafka.producer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class PersonTopicProducer {
    
    Logger logger = LoggerFactory.getLogger(PersonTopicProducer.class);
    
    private KafkaTemplate<Object, Object> kafkaTemplate;
    
    public PersonTopicProducer(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public void produce(int start, int end) {
        for (int i = start; i <= end; i++) {
            String template =
                    "{\n" +
                    "  \"id\": %1$d,\n" +
                    "  \"name\": \"Test_%1$d\",\n" +
                    "  \"email\":  \"mail_%1$d@mail.com\"\n" +
                    "}";
            String message = String.format(template, i);
            kafkaTemplate.send("person-topic", message);
            logger.info("sent: {}", message);
        }
    }
    
}
