package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: xuyisheng
 * @Description kdfka测试demo
 * @Date: 2020/3/5 8:57
 * @Param
 * @return
 **/
@RestController
public class KafkaDemo
{

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/kafka")
    public void sendKafka(){
        System.out.println("send kafka enter");
        try
        {
//            int iMax = 100;
//            for (int i = 1; i < iMax; i++){
//                kafkaTemplate.send("test","key" + i, "data" + i);
//            }
            while (true){
                kafkaTemplate.send("test","key" + UUID.randomUUID().toString(), "data" + System.currentTimeMillis());
            }
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("sendKafka error: " + ex.getMessage());
        }
    }

    @KafkaListener(topics = "test")
    private void receive(ConsumerRecord<?,?> consumer){
        System.out.println(consumer.topic() + " - " + consumer.key() + ":" + consumer.value());
    }
}
