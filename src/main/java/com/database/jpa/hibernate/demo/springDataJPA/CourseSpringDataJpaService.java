package com.database.jpa.hibernate.demo.springDataJPA;

import com.database.jpa.hibernate.demo.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CourseSpringDataJpaService
{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository courseSpringDataRepository;

//    @Transactional
    public void saveCourse()
    {
        Course course = new Course();
        course.setName("Mounika");
        courseSpringDataRepository.save(course);
        course.setName("new Mounika");

        Optional<Course> optional = courseSpringDataRepository.findById(10001l);
    }

    public void playIngAroundWithSpringDataJPA()
    {
        Course course = new Course();
        course.setName("Mounika");
        courseSpringDataRepository.save(course);

        course.setName("new Mounika");
        courseSpringDataRepository.save(course); //here we have to explicitly call save method after updating name in course.
        //Try learn difference between saving through EntityManager and JPARepository
    }

    @Transactional
    public void playIngAroundWithSpringDataJPACache()
    {
        Optional<Course> course = courseSpringDataRepository.findById(10001L);//Retrieved from database for 1st time.
        Optional<Course> course1 = courseSpringDataRepository.findById(10001L);// This is retrieved from cache(Persistent Context) since we are in single transaction.
//        If we remove transactional above, then above both will get data from database.
//        The most important concept when you want to make use of the first level cache is the boundary of the transaction.
//        If you want to make the best use of first level cash then the boundary of the transaction should start with service method(@Transaction should be at service method).
    }


    public void sort()
    {
        Sort sort = Sort.by(Arrays.asList(new Sort.Order(Sort.Direction.ASC, "name")));
        logger.info("Sorted by Name", courseSpringDataRepository.findAll(sort));
    }

    public void pageRequest()
    {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<Course> firstPage = courseSpringDataRepository.findAll(pageRequest);
        logger.info("First Page", firstPage.getContent());

        Pageable secondPageable = firstPage.nextPageable();
        Page<Course> secondPage = courseSpringDataRepository.findAll(secondPageable);
        logger.info("Second Page", secondPage.getContent());

    }
}
