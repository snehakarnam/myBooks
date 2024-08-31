package com.mybooks.app.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "topic", groupId = "subscription-consumer-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }

}

