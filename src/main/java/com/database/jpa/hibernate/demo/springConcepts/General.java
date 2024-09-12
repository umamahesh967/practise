package com.database.jpa.hibernate.demo.springConcepts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Component, @Service, @Repository, @Controller
 *
 * Above four annotations doesn't provide any additional functionalities.It same as @Component.
 * It's just by using different annotations we can add different functionalities using SpringAOP.
 *
 * @Bean vs @Component
 * https://stackoverflow.com/questions/10604298/spring-component-versus-bean#:~:text=Both%20approaches%20aim%20to%20register,With%20%40Component%20annotation%20you%20cannot.
 *
 * method with @bean returns a customizable instance of spring bean,
 * while @component defines a class that may be later instantiated by spring IoC engine when needed.
 *
 * @Good video for learning all annotations
 * https://www.youtube.com/watch?v=x_-Tx6OFYLg
 *
 * @Inject vs @Autowired
 * https://javarevisited.blogspot.com/2017/04/difference-between-autowired-and-inject-annotation-in-spring-framework.html#:~:text=The%20%40Autowired%20annotation%20is%20used,auto%2Dwiring%20in%20Spring%20framework.&text=The%20%40Inject%20annotation%20also%20serves,and%20%40Autowired%20is%20spring%20specific.
 *
 */
@Component
public class General
{
    @Value("${user.mail.address}")
    private String mail;
}
