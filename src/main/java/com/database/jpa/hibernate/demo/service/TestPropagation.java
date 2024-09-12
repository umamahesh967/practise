package com.database.jpa.hibernate.demo.service;

import com.database.jpa.hibernate.demo.entity.Course;
import com.database.jpa.hibernate.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TestPropagation
{

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TestNestedTransactions testNestedTransactions;

//    @Transactional(propagation = Propagation.REQUIRED)
    public void testPropagation1()
    {
        testNestedTransactions.testPropagation7();
        System.out.println("Hi");
    }

    @Transactional()
    public void testSample()
    {
        Course course = new Course("New row1");
        entityManager.persist(course); //Course is created for first time
//        testPropagation4();
//        Course course1 = entityManager.find(Course.class, 10001L);
//        course1.setName("mahesh");
        try {
            testNestedTransactions.test1();
        }
        catch (Exception e)
        {

        }
        course.setName("New name1");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void testPropagation2()
    {

    }

    @Transactional(propagation = Propagation.NESTED)
    public void testPropagation3()
    {

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testPropagation4()
    {
        Course course = new Course("New row2");
        entityManager.persist(course); //Course is created for first time
        course.setName("New name2");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testPropagation5()
    {

        Double d = 0.0;
        if(d>0)
        {
            System.out.println("Yaay");
        }
        Map<String, Integer> map = new HashMap();
        map.put("a", 5);
        map.put("b", 0);
        map.put("c", -1);
        map.put("d", 0);
        map.put("e", -9);
        map.put("f", 4);

        Comparator<Map.Entry<String, Integer>> comparator = (a, b) -> {
            if(a.getValue() == 0)
            {
                return -1;
            }
            else if(b.getValue() == 0)
            {
                return 1;
            }else
            {
                return a.getValue().compareTo(b.getValue());
            }
        };



        map = map.entrySet()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(map);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void testPropagation6()
    {

    }

    @Transactional(propagation = Propagation.NEVER)
    public void testPropagation7()
    {
        Course course = new Course("New row1");
//        entityManager.persist(course); //Course is created for first time
    }
}
