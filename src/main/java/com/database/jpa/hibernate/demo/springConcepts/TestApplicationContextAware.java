package com.database.jpa.hibernate.demo.springConcepts;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * If you want to access the application context in any other place then if we implements ApplicationContextAware
 * then context will be passed in the setApplicationContext method.
 *
 */
@Component
public class TestApplicationContextAware implements ApplicationContextAware
{
    @Autowired
    ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.context = applicationContext;
    }
}
