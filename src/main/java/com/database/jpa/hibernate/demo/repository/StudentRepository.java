package com.database.jpa.hibernate.demo.repository;

import com.database.jpa.hibernate.demo.entity.Course;
import com.database.jpa.hibernate.demo.entity.Passport;
import com.database.jpa.hibernate.demo.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public Student findById(Long id)
    {
        return entityManager.find(Student.class, id);
    }

    public void deleteById(Long id)
    {
        Student entity = findById(id);
        entityManager.remove(entity);
    }

    public Student save(Student student)
    {
        if(student.getId() == null)
        {
            entityManager.persist(student);
        }
        else
        {
            entityManager.merge(student);
        }
        return student;
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        entityManager.persist(passport);

        Student student = new Student("Mike");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    @Transactional
    public void retrieveStudentAndCourses() {
        Student student = entityManager.find(Student.class, 20001L);

        logger.info("student -> {}", student);
        logger.info("courses -> {}", student.getCourses());
    }

    @Transactional
    public void retrievePassportAndAssociatedStudent() {
        Passport passport = entityManager.find(Passport.class, 40001L);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}", passport.getStudent());
    }

    public void insertHardcodedStudentAndCourse(){
        Student student = new Student("Jack");
        Course course = new Course("Microservices in 100 Steps");
        entityManager.persist(student);
        entityManager.persist(course);

        student.addCourse(course);
        course.addStudent(student);
        entityManager.persist(student); //We just need to persist the table which is owning the relation. No need of persisting the course object after establishing the relation.
    }

    public void insertStudentAndCourse(Student student, Course course){
        //Student student = new Student("Jack");
        //Course course = new Course("Microservices in 100 Steps");
        student.addCourse(course);
        course.addStudent(student);

        entityManager.persist(student);
        entityManager.persist(course);
    }
}
