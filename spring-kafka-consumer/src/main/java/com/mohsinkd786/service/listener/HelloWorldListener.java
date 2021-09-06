package com.mohsinkd786.service.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldListener {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldListener.class);

    @KafkaListener(topics = "${spring.kafka.consumer.topic.name}")
    public void onMessage(String message){
        logger.info("START : Hello World Listener ###########");
        logger.info(message);
        logger.info("END : Hello World Listener ###########");
    }
}
