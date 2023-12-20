package com.mose.springboot.controller;

import com.mose.springboot.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {
private final KafkaProducer kafkaProducer;
        @GetMapping("/send")
        //localhost:8080/api/v1/message/send?message=Hello World
       public ResponseEntity<String> publishMessage(@RequestParam("message") String message) {
            kafkaProducer.sendMessage(message);
       return new ResponseEntity<>("Message sent to Kafka Topic", HttpStatus.OK);
           // return ResponseEntity.ok("Message sent to kafka topic");
        }
}
