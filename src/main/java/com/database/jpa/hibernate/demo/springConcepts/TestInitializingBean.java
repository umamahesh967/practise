package com.database.jpa.hibernate.demo.springConcepts;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Inorder to have method that gets initialized when the bean is called we have to implement InitializingBean.
 */
@Component
public class TestInitializingBean implements InitializingBean, DisposableBean
{
    @Autowired
    LoadConfigProperties loadConfigProperties;

    public TestInitializingBean()
    {
        System.out.println("InitializingBean Constructor.");
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        System.out.println("InitializingBean method is called for triangle during initialization.");
    }

    @Override
    public void destroy() throws Exception
    {
        System.out.println("Destroy method is called when destroying the bean.");
    }
}
