package com.database.jpa.hibernate.demo.repository;

import com.database.jpa.hibernate.demo.entity.Course;
import com.database.jpa.hibernate.demo.entity.Review;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * This is normal class which uses normal JPA. Which has nothing to spring-data.
 *
 * JPA defines the standard set of rules for ORM(Object Relational Mapping) i.e mapping object to table record in database.
 *
 */
@Repository
@Transactional(rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
public class CourseRepository
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    EntityManager entityManager;

    public Course findById(Long id)
    {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id)
    {
        Course entity = findById(id);
        entityManager.remove(entity);
    }

    public Course save(Course course)
    {
        if(course.getId() == null)
        {
            entityManager.persist(course);
        }
        else
        {
            entityManager.merge(course);
        }
        return course;
    }

    // here the below entire method is in single transaction
    public void playWithEntityManager() throws Exception {
        //While we are with in the scope of single transaction, entityManager will keep track of things that
        //were updated/modified through it.
        Course course = new Course("New row1");
        entityManager.persist(course); //Course is created for first time
        entityManager.flush();
        throw new Exception(){};
//        course.setName("New name1");
//        course.setName("New name2");
        //Here in above two lines name field is reset. At the end of the transaction course object
        // with name "New name2" is saved into database even though we didn't explicitly call entityManager to merge.
        // as we are in single transaction entity manager will automatically take's care of updating the course object with new name.
    }

    // here the below entire method is in single transaction
    public void playWithEntityManager2()
    {
        Course course = new Course("Row2");
        entityManager.persist(course); //entityManager will keep track of course object, but it will not be immediately saved in database. It will be saved in something called persistence context.
//        entityManager.flush(); //calling flush on entityManager, those changes which are in persistence context will be committed to database.

        course.setName("New name for Row2");
//        entityManager.flush();

//        course.setName("New new name for Row2");

        Course course2 = new Course("Row3");
        entityManager.persist(course2); //Course2 is created and persisted for first time
        entityManager.flush(); //Even if do flush if some exception occurs in below code, above code changes will be reverted back.

        entityManager.detach(course2);
        //On calling above method, The changes to course2 are no longer tracked by the entityManager.
        // Meaning below name change for course2 will not be saved to database.

        entityManager.clear(); //if we clear on entityManager then no object is tracked. AFTER that whatever we
        // update, unless we explicitly call entityManager methods those updates will not be saved in database.

        course2.setName("New name for Row3"); //this will not be save we call flush method below.
        entityManager.flush();
    }

    public void playWithEntityManager3()
    {
        Course course = new Course("Row2");
        entityManager.persist(course); //Course2 is created and persisted for first time
//        Course course2 = new Course("Row3");
//        entityManager.persist(course2); //Course2 is created and persisted for first time
        entityManager.flush();

        course.setName("New name for Row2");
//        course2.setName("New name for Row3");

        entityManager.refresh(course); // if we do refresh, entityManager will not keep track of updated things on the object that we have refreshed.
        //It will refresh with the changes what we have/saved in database. If object is saved by calling flush() before calling refresh() on object then it's fine or else
        // we will get IllegalStateException
    }

    public void playWithEntityManager4()
    {
        Course course = new Course("Row2");
        entityManager.persist(course); //Course2 is created and persisted for first time
        Course course2 = new Course("Row3");
        entityManager.persist(course2); //Course2 is created and persisted for first time
        entityManager.flush();

        course.setName("New name for Row2");
        course2.setName("New name for Row3");

        entityManager.refresh(course); // course saved with name "Row2", course2 saved with name "New name for Row3"
    }

    public void playWithEntityManager5()
    {
        Course course = new Course("Row2");
        entityManager.persist(course); //Course2 is created and persisted for first time

        Course course1 = findById(10001l);
        course1.setName("Updated");
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        logger.info("course.getReviews() -> {}", course.getReviews());
        for(Review review:reviews)
        {
            //setting the relationship
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        }
    }

    /**
     * By Default readOnly property is false,
     *
     * If we are sure we are doing only readOnly operations then we can explicitly set readOnly to true.
     *
     * If we set readOnly to true and try to do write operations then we will not get any error, but the object will not be saved in the database.
     */
    @Transactional(readOnly = true)
    public void saveCourse()
    {
//        Course course = entityManager.find(Course.class, 10001L);
//        course.setName("Mahesh");
        Course course = new Course("Row2");
        entityManager.persist(course);
    }

    public void test1()
    {
//        SessionFactoryImpl sessionFactory = new SessionFactoryImpl();
    }
}
