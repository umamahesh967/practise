package com.database.jpa.hibernate.demo.springConcepts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DI
{
    @Autowired
    ConstructorInjection injection;

//    @Autowired
//    SpringIOC ioc;

    //Constructor Injection
//    @Autowired
//    public Test(ConstructorInjection constructorInjection, SpringIOC springIOC)
//    {
//        System.out.println("Constructor Injection");
//        this.injection = constructorInjection;
//        this.ioc = springIOC;
//    }

    //Setter Injection
//    @Autowired
    public void setConstructorInjection(ConstructorInjection constructorInjection) {
        System.out.println("Setter Injection");
        this.injection = constructorInjection;
    }


//    @Autowired
//    public void setSpringIOC(SpringIOC springIOC) {
//        System.out.println("SpringIOC Setter Injection");
//        this.ioc = springIOC;
//    }

    @PostConstruct //This method is called after initialization of dependencies.
    public void xy(){}

    @PreDestroy  //This method is called just before this bean is removed from context.
    public void destroy(){}
}
