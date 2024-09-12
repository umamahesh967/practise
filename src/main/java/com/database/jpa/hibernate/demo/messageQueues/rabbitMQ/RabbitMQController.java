//package com.database.jpa.hibernate.demo.messageQueues.rabbitMQ;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("rabbitmq")
//public class RabbitMQController
//{
//    @Autowired
//    RabbitTemplate rabbitTemplate;
//
//    @GetMapping("/send/{message}")
//    public String sendMessage(@PathVariable("message") String message)
//    {
//        rabbitTemplate.convertAndSend(ConfigureRabbitMQ.EXCHANGE_NAME,
//                "bindingkey.anykey", message);
//        return "We have sent Message";
//    }
//}
