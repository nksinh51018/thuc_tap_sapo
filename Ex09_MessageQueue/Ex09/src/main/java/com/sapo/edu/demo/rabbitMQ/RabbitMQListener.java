package com.sapo.edu.demo.rabbitMQ;

import com.sapo.edu.demo.entity.Record;
import com.sapo.edu.demo.repository.RecordRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {

    @Autowired
    private RecordRepository recordRepository;

    @RabbitListener(queues = RabbitMQConfiguration.DEFAULT_PARSING_QUEUE)
    public void consumeDefaultMessage(String warehouseCode){
        System.out.println(warehouseCode);
        recordRepository.count(warehouseCode);
    }

}
