package com.example.demo;

import com.example.demo.service.ProductService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    private ProductService productService;

    @RabbitListener(queues = RabbitMQConfiguration.DEFAULT_PARSING_QUEUE)
    public void consumeDefaultMessage(ProductDTO productDTO){
        System.out.println(productDTO.toString());
        productService.insertProduct(productDTO);
    }

}
