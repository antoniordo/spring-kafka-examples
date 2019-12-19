package com.antoniordo.kafka.consumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * A simple consumer receiving a message in string format.
 */
@Component
@KafkaListener(topics = "simple-topic")
public class SimpleConsumer {
    
    Logger logger = LoggerFactory.getLogger(SimpleConsumer.class);
    
    @KafkaHandler
    public void receive(String message) {
    
        logger.info("Received message: {}", message);
    
        if (message.toLowerCase().contains("error")) {
            throw new RuntimeException("Error from Consumer!");
        }
    
        SleepUtil.sleep();
        
    }
    

}
