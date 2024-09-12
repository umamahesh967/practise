//package com.database.jpa.hibernate.demo.messageQueues.kafka;
//
//import com.database.jpa.hibernate.demo.entity.Student;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaConsumer
//{
//    @KafkaListener(topics = "Kafka_Example", groupId = "group_id", containerFactory = "concurrentKafkaListenerContainerFactory")
//    public void consume(Student student)
//    {
//        System.out.println("Consumed Message: "+student);
//    }
//}
