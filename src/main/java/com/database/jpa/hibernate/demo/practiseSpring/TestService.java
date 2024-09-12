package com.database.jpa.hibernate.demo.practiseSpring;

import com.database.jpa.hibernate.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService
{

    @Autowired
    SpringDataRepository dataRepository;

    @Transactional
    public Course createCourse(Course course)
    {
        /**
         * Populate missing fields
         *
         * Populate computed fields
         *
         * Check If All Required Properties Are In Entity
         *
         * Validation
         *
         * Raise events based on the updated fields
         */
        return dataRepository.save(course);
    }

    public List<Course> findAll()
    {
        return dataRepository.findAll();
    }

    public Course find(String id)
    {
        return dataRepository.findByName(id);
    }
}
