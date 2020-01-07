package com.antoniordo.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

@EnableKafka
@SpringBootApplication
public class KafkaConsumerApplication {
    
    @Bean
    public KafkaListenerContainerFactory<?> kafkaJsonListenerContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
                                                                              ConsumerFactory<Object, Object> consumerFactory,
                                                                              KafkaTemplate<? extends Object, ? extends Object> kafkaTemplate) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        configurer.configure(factory, consumerFactory);
        factory.setConsumerFactory(consumerFactory);
        factory.setMessageConverter(new StringJsonMessageConverter()); // enable conversion to domain object
        factory.setErrorHandler(kafkaErrorHandler(kafkaTemplate));
        return factory;
    }
    
    private ErrorHandler kafkaErrorHandler(KafkaTemplate<? extends Object, ? extends Object> kafkaTemplate) {
        return new SeekToCurrentErrorHandler(new DeadLetterPublishingRecoverer(kafkaTemplate));
    }
    
    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }

}
