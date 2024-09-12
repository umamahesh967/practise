package com.database.jpa.hibernate.demo.forTesting;

import com.database.jpa.hibernate.demo.entity.Course;
import com.database.jpa.hibernate.demo.entity.Passport;
import com.database.jpa.hibernate.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test1
{
    @Autowired
    Test2 test2;

    public Test1(){
    }

    public Student m1(Course course)
    {
       Student student = test2.m2(new Passport());

       return student;
    }
}
