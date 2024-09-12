package com.database.jpa.hibernate.demo.aop.data;

import com.database.jpa.hibernate.demo.aop.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao2
{
    @TrackTime
    public String retrieveSomething()
    {
        return "Dao2";
    }
}
