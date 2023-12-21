package com.mose.springboot.controller;

import com.mose.springboot.dto.User;
import com.mose.springboot.kafka.JsonKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
public class JsonMessageController {

    private final JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/send")
    public ResponseEntity<String> publishMessage(@RequestBody User user ){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to kafka topic");
        //return new ResponseEntity<>("Message sent to Kafka Topic", HttpStatus.OK);
    }

}
