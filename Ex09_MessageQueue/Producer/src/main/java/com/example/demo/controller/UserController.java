package com.example.demo.controller;

import com.example.demo.RabbitMQConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final String TOPIC = "report";

    @PostMapping("/publish")
    public String post(@RequestBody String warehouseCode){
        kafkaTemplate.send(TOPIC,warehouseCode,warehouseCode);
        System.out.println(warehouseCode);
        return "Publish with kafka successfully";
    }

    @PostMapping("/publish/rabbit")
    public String postRabbit(@RequestBody String warehouseCode){
        rabbitTemplate.convertAndSend(RabbitMQConfiguration.EXCHANGE_NAME,RabbitMQConfiguration.ROUTING_KEY,warehouseCode);
        System.out.println(warehouseCode);
        return "Publish with rabbitMQ successfully";
    }


}
