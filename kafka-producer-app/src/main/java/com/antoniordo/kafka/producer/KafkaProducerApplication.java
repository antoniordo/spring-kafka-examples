package com.antoniordo.kafka.producer;

import com.antoniordo.kafka.producer.producer.PersonTopicProducer;
import com.antoniordo.kafka.producer.producer.SimpleTopicProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableKafka
@EnableScheduling
@SpringBootApplication
public class KafkaProducerApplication {
    
    @Bean
    public SimpleTopicProducer exampleProducer(KafkaTemplate<Object, Object> kafkaTemplate) {
        return new SimpleTopicProducer(kafkaTemplate);
    }
    
    @Bean
    public PersonTopicProducer presonJsonProducer(KafkaTemplate<Object, Object> kafkaTemplate) {
        return new PersonTopicProducer(kafkaTemplate);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }
    
}
