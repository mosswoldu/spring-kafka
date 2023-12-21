package com.mose.springboot.kafka;

import com.mose.springboot.dto.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JsonKafkaProducer {
    private static final Logger LOGGER= LoggerFactory.getLogger(JsonKafkaProducer.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User userData) {
        LOGGER.info(String.format("Message sent-> %s", userData.toString()));
//        kafkaTemplate.send("mose-topic", userData);
        //Message interface have two abstract methods: getPayload() and getHeaders()
        Message<User> message = MessageBuilder
                .withPayload(userData)
                .setHeader(KafkaHeaders.TOPIC, "mose-json-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
