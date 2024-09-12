package com.database.jpa.hibernate.demo.aop.business;

import com.database.jpa.hibernate.demo.aop.data.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2
{
    @Autowired
    Dao2 dao2;

    public String calculateSomething()
    {
        return dao2.retrieveSomething();
    }
}
