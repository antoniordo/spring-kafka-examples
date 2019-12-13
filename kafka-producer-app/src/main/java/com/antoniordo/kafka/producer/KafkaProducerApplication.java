package com.antoniordo.kafka.producer;

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
    public ExampleProducer exampleProducer(KafkaTemplate<Object, Object> kafkaTemplate) {
        return new ExampleProducer(kafkaTemplate);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }
    
}
