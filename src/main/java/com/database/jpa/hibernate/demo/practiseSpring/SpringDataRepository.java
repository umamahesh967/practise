package com.database.jpa.hibernate.demo.practiseSpring;

import com.database.jpa.hibernate.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SpringDataRepository extends JpaRepository<Course, String>
{
    Course findByName(String name);
}
