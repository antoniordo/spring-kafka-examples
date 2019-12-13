package com.antoniordo.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

@KafkaListener(topics = "example")
public class ExampleConsumer {
    
    Logger logger = LoggerFactory.getLogger(ExampleConsumer.class);
    
    @KafkaHandler
    public void receive(String message) {
    
        if (message.toLowerCase().contains("error")) {
            throw new RuntimeException("Error from Consumer!");
        }
        
        logger.info("Received message: {}", message);
    
    }
    

}
