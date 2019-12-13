package com.antoniordo.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicLong;

public class ExampleProducer {
    
    public static final String EXAMPLE_TOPIC = "example";
    
    Logger logger = LoggerFactory.getLogger(ExampleProducer.class);
    
    private final long executionId = System.currentTimeMillis();
    private AtomicLong count = new AtomicLong(0);
    
    private KafkaTemplate<Object, Object> kafkaTemplate;
    
    public ExampleProducer(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = String.format("example %d_%d", executionId, count.incrementAndGet());
        kafkaTemplate.send(EXAMPLE_TOPIC, message);
        logger.info("Sent message: {}", message);
    }
    
}
