//package com.database.jpa.hibernate.demo.messageQueues.rabbitMQ;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.MessageListener;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ConfigureRabbitMQ
//{
//    public static final String EXCHANGE_NAME = "ExchangeName";
//    public static final String QUEUE_NAME = "ExchangeName";
//
//    @Bean
//    Queue createQueue()
//    {
//        return new Queue(QUEUE_NAME, false);
//    }
//
//    @Bean
//    TopicExchange exchange()
//    {
//        return new TopicExchange(EXCHANGE_NAME);
//    }
//
//    @Bean
//    Binding binding(Queue queue, TopicExchange topicExchange)
//    {
//        return BindingBuilder.bind(queue).to(topicExchange).with("bindingkey.#");
//    }
//
//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//                                             MessageListenerAdapter messageListener)
//    {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(QUEUE_NAME);
//        container.setMessageListener(messageListener);
//        return container;
//    }
//
//
//    @Bean
//    MessageListenerAdapter messageListenerAdapter(ReceiveMessageHandler handler)
//    {
//        return new MessageListenerAdapter(handler, "handleMessage"); //"handleMessage" is name of the method which is called using reflection
//    }
//}
