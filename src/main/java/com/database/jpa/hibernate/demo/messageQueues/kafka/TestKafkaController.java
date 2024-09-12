//package com.database.jpa.hibernate.demo.messageQueues.kafka;
//
//import com.database.jpa.hibernate.demo.entity.Passport;
//import com.database.jpa.hibernate.demo.entity.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("kafka")
//public class TestKafkaController
//{
//
//    static final String TOPIC = "Kafka_Example";
//
//    /**
//     * Since I am sending a custom Student object we need to provide the Serializer config.
//     * For that I have defined the configuration.
//     */
//    @Autowired
//    KafkaTemplate<String, Student> kafkaTemplate;
//
//    @GetMapping("/publish/{message}")
//    public String post(@PathVariable("message") String message)
//    {
//        Student student = new Student();
//        student.setName(message);
//        student.setPassport(new Passport());
//        student.getPassport().setNumber("AEGPU5788R");
//
//        kafkaTemplate.send(TOPIC, student);
//        return "Message Published";
//    }
//}
