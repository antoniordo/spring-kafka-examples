package com.antoniordo.kafka.producer.web;

import com.antoniordo.kafka.producer.producer.PersonTopicProducer;
import com.antoniordo.kafka.producer.producer.SimpleTopicProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    
    Logger logger = LoggerFactory.getLogger(ProducerController.class);
    
    private SimpleTopicProducer simpleTopicProducer;
    private PersonTopicProducer personTopicProducer;
    
    public ProducerController(SimpleTopicProducer simpleTopicProducer,
                              PersonTopicProducer personTopicProducer) {
        this.simpleTopicProducer = simpleTopicProducer;
        this.personTopicProducer = personTopicProducer;
    }
    
    @GetMapping("/api/producer/simple-topic")
    public void simpleTopicProducer(@RequestParam(value="start", defaultValue="1") int start,
                                    @RequestParam(value="end", defaultValue="10")int end) {
        logger.info("Request to produce to simple-topic");
        simpleTopicProducer.produce(start, end);
        logger.info("Request completed");
    }
    
    @GetMapping("/api/producer/person-topic")
    public void personTopicProducer(@RequestParam(value="start", defaultValue="1") int start,
                                    @RequestParam(value="end", defaultValue="10")int end) {
        logger.info("Request to produce to person-topic");
        personTopicProducer.produce(start, end);
        logger.info("Request completed");
    }
    
}
