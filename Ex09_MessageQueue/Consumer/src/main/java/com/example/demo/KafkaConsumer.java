package com.example.demo;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private ProductService productService;

    @KafkaListener(topics = {"Kafka"},groupId = "Group_id")
    public void consume(String message){
        System.out.println(message);
    }

    @KafkaListener(topics = {"Kafka_json5"},groupId = "Group_json",containerFactory = "productDTOKafkaListenerContainerFactory")
    public void consumeJson(ProductDTO productDTO){
        System.out.println(productDTO);
//        productService.insertProduct(productDTO);
    }

}
