package com.sapo.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserKafka {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping
    public ResponseEntity report(@RequestBody String warehouseCode){
        System.out.println(warehouseCode);
        kafkaTemplate.send("report",warehouseCode,warehouseCode);
        return new ResponseEntity<>(
                "Report successfully",
                HttpStatus.OK
                );
    }

}
