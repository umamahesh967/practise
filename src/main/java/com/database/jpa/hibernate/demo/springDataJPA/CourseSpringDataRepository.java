package com.database.jpa.hibernate.demo.springDataJPA;

import com.database.jpa.hibernate.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is class which uses spring-data-jpa. There is another class(CourseRepository) which uses normal JPA.
 */
//@Repository
@RepositoryRestResource // start the server and look at http://localhost:8080/courses
public interface CourseSpringDataRepository extends JpaRepository<Course, Long>
{

//    Course findById(String id);

    List<Course> findByName(String name);

    List<Course> countByName(String name);

    List<Course> findByNameAndId(String name, Long id);

    List<Course> findByNameOrderByIdDesc(String name);

    List<Course> deleteByName(String name);

    @Query("Select c from Course c where name like '%50 Steps'") //JPQL Query
    List<Course> coursesWithHundredStepsJPQLQuery(String name);

    @Query( value = "Select * from Course c where name like '%50 Steps'", nativeQuery = true) //SQL Query
    List<Course> coursesWithHundredStepsNativeQuery(String name);

    @Query( name = "query_get_all_courses") //Named Query
    List<Course> coursesWithHundredStepsNamedQuery(String name);
}
