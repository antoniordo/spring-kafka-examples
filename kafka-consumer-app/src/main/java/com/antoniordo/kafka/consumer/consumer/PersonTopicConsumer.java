package com.antoniordo.kafka.consumer.consumer;

import com.antoniordo.kafka.consumer.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * This consumer uses a Message Converter configured with kafkaJsonListenerContainerFactory to convert topic payload
 * to Person object (see configuration).
 *
 * @see com.antoniordo.kafka.consumer.KafkaConsumerApplication#kafkaJsonListenerContainerFactory
 */
@Component
public class PersonTopicConsumer {
    
    Logger logger = LoggerFactory.getLogger(PersonTopicConsumer.class);
    
    @KafkaListener(topics = "person-topic", containerFactory = "kafkaJsonListenerContainerFactory")
    public void receive(Person person) {
        
        logger.info("Processing Person: {}", person);
        SleepUtil.sleep();
    
        if (person.getName().toLowerCase().contains("error")) {
            throw new RuntimeException("Error processing Person!");
        }
        
        logger.info("Processed Person: {}", person);
        
    }
    
}
