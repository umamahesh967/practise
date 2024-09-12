//package com.database.jpa.hibernate.demo;
//
//import com.database.jpa.hibernate.demo.entity.Course;
//import com.database.jpa.hibernate.demo.entity.Passport;
//import com.database.jpa.hibernate.demo.entity.Student;
//import com.database.jpa.hibernate.demo.forTesting.Test1;
//import com.database.jpa.hibernate.demo.forTesting.Test2;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration(classes = {TestConfig.class})
//@RunWith(SpringRunner.class) //Is ued to launch the spring context
//@SpringBootTest(classes = DemoApplication.class) //We want to launch the entire DemoApplication context here.
//public class Test1ComponentTest
//{
//
//    @Autowired
//    Test1 test1;
//
////    @Autowired
////    Test2 test2;
//
//    @Test
//    void contextLoads()
//    {
//        Student student = new Student();
//        student.setName("Mahesh");
//        student.setPassport(new Passport());
//
//        Student result = test1.m1(new Course());
//        Assert.assertEquals("Mahesh", result.getName());
//    }
//}
