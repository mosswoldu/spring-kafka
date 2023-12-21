package com.mose.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "mositi", groupId = "group_id")
    public void consume(String message) {
      //  System.out.println("Consumed message: " + message);
        LOGGER.info(String.format("Consumed message -> %s", message));
    }
}
