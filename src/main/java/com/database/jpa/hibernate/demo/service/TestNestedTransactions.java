package com.database.jpa.hibernate.demo.service;

import com.database.jpa.hibernate.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
public class TestNestedTransactions
{

    @Autowired
    EntityManager entityManager;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test1()
    {
        Course course = new Course("New row2");
        entityManager.persist(course); //Course is created for first time
        course.setName("New name2");
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void test2()
    {
        Course course = new Course("New row2");
        entityManager.persist(course); //Course is created for first time
        course.setName("New name2");
    }

    @Transactional(propagation = Propagation.NEVER)
    public void testPropagation7()
    {
        Course course = new Course("New row1");
        entityManager.persist(course); //Course is created for first time
    }
}
