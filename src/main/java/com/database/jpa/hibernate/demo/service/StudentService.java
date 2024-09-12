package com.database.jpa.hibernate.demo.service;

import com.database.jpa.hibernate.demo.entity.Passport;
import com.database.jpa.hibernate.demo.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class StudentService
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    @Transactional
    public Student retrieveStudentAndPassportDetails()
    {
        Student student = entityManager.find(Student.class, 20001L); //Here student doesn't get passport details
        //because passport is lazily loaded.

        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());// here passport details are loaded from
        // database for student object. This is possible because we are in still transaction.
        //If we remove transactional in the method and fetchtype is lazy for passport in student entity then we will get exception here.
        return student;
    }

    /**
     * Whenever we call method on entitymanager, what we are playing with is persistence context.
     * In JPA we use entityManager(acts as interface to persistence context) to talk to persistence context.
     * Persistence context is the place where all the changes are kept track of.
     * Persistence context is created at the start of the transaction and killed at the end of the transaction.
     *
     * If we have transaction at method level meaning whole operations inside method will have single persistence context.
     *
     * If we don't have transaction at method level meaning each operation/Instruction inside method
     * will act like separate/single transaction and have separate/single persistence context.
     * So one instruction to another will have different persistence context.
     *
     * In Hibernate Terminology Persistence Context is called Session.
     *
     * (Hibernate)Session = Persistence Context
     *
     * https://udemy.com/course/hibernate-jpa-tutorial-for-beginners-in-100-steps/learn/lecture/7907518#overview
     */
    @Transactional //As soon we define Transaction you would also be creating something called persistence context
    public void someOperationToUnderstandPersistenceContext()
    {
        //Database Operation 1 - Retrieves student
        Student student = entityManager.find(Student.class, 20001L);
        //Persistence Context (student)

        //Database Operation 2 - Retrieves passport
        Passport passport = student.getPassport();// If we don't have transaction at method level and if it is Lazy initialised then this line would throw exception(because of different persistence context.)
        //Persistence Context (student, passport)

        //Database Operation 3 - update passport
        passport.setNumber("E123457");
        //Persistence Context (student, passport++)

        //Database Operation 4 - updates student
        student.setName("Ranga - updated");
        //Persistence Context (student++, passport++)
    }

    @Transactional
    public void retrievePassportAndStudentDetails()
    {
        Passport passport = entityManager.find(Passport.class, 40001L);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}", passport.getStudent());// here passport details are loaded from
        // database for student object. This is possible because we are in still transaction.
        //If we remove transactional in the method and fetchtype is lazy for passport in student entity then we will get exception here.
    }
}
