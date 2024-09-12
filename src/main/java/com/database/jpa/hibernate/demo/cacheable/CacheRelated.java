package com.database.jpa.hibernate.demo.cacheable;

import com.database.jpa.hibernate.demo.entity.Course;
import com.database.jpa.hibernate.demo.springDataJPA.CourseSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * The first level cache is within the boundary of the transaction. i.e in the single transaction
 * it will be stored in persistence context. so persistence context act as first level cache.
 * So if you are trying to retrieve the same data in the same transaction it will be retrieved from first level cache.
 *
 * The Second level cache comes into picture across multiple Transactions.
 * We can store information which is common to all transactions in second level cache. eg(list of countries, country states)
 *
 * In any transaction if we want to retrieve data, then first it goes to
 * persistence context(first level cache) if it is not present then it goes to second level cache
 * if it is not present there then it goes to database.
 *
 * After getting details/data from database we put it in both first and second level cache.
 * From then on in any other transaction if we try to retrieve same data, we will get it from second level cache.
 * From then on in same transaction if we try to retrieve same data, we will get it from first level cache.
 *
 * Go through below article where it is explained nicely.
 * https://stackoverflow.com/questions/337072/what-are-the-first-and-second-level-caches-in-hibernate#:~:text=First%20level%20cache%20is%20associated%20with%20%E2%80%9Csession%E2%80%9D%20object.&text=When%20we%20query%20an%20entity,sql%20query%20will%20be%20executed.
 *
 */
@Component
public class CacheRelated
{

    @Autowired
    CourseSpringDataRepository courseSpringDataRepository;

    @Transactional
    public void playIngAroundWithSpringDataJPACache()
    {
        Optional<Course> course = courseSpringDataRepository.findById(10001L);//Retrieved from database for 1st time.
        Optional<Course> course1 = courseSpringDataRepository.findById(10001L);// This is retrieved from cache(Persistent Context) since we are in single transaction.
//        If we remove transactional above, then above both will get data from database.
//        The most important concept when you want to make use of the first level cache is the boundary of the transaction.
//        If you want to make the best use of first level cash then the boundary of the transaction should start with service method(@Transaction should be at service method).
//        Generally it is recommended to start the @Transaction at service level, so if we are trying to retrieve same data it will be retrieved from cache.
    }


    public void notRetrievedFromCache()
    {
        Optional<Course> course = courseSpringDataRepository.findById(10001L);//Retrieved from database for 1st time.
        Optional<Course> course1 = courseSpringDataRepository.findById(10001L);//This is also retrieved from database not from cache because we are not in transaction.
        // Above data is not retrieved from cache(Persistent Context) because since we are not in transaction.
    }

    /**
     * Ehcache acts as second level cache.
     * https://udemy.com/course/hibernate-jpa-tutorial-for-beginners-in-100-steps/learn/lecture/7907642#overview
     * https://udemy.com/course/hibernate-jpa-tutorial-for-beginners-in-100-steps/learn/lecture/7907646#overview
     */
}
