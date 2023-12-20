package com.mose.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
@Bean

    public NewTopic moseTopic() {
       // return new NewTopic("mose-topic", 1, (short) 1);
        return TopicBuilder
                .name("mose-topic")
                //.partitions(10)
                //.replicas(1)
                .build();
    }
}
