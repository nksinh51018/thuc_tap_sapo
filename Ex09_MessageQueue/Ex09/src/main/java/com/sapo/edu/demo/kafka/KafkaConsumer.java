package com.sapo.edu.demo.kafka;

import com.sapo.edu.demo.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private RecordRepository recordRepository;

    @KafkaListener(topics = {"report"},groupId = "Group_id")
    public void consume(String message){
        System.out.println(message);
        recordRepository.count(message);
    }


}
