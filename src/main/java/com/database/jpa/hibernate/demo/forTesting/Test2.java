package com.database.jpa.hibernate.demo.forTesting;

import com.database.jpa.hibernate.demo.entity.Course;
import com.database.jpa.hibernate.demo.entity.Passport;
import com.database.jpa.hibernate.demo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class Test2
{
    public Test2() {
    }

    public Student m2(Passport passport)
    {
        Student student = new Student();
        student.setName("Mahesh");
        return student;
    }
}
