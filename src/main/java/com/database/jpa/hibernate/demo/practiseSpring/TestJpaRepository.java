package com.database.jpa.hibernate.demo.practiseSpring;

import com.database.jpa.hibernate.demo.entity.Course;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class TestJpaRepository
{
    @PersistenceContext
    EntityManager entityManager;

    public Course find(Long id)
    {
        return entityManager.find(Course.class, id);
    }

    /**
     * In case of persist method, if the entity that is to be managed in the persistence context,
     * already exists in persistence context, the new one is ignored. (NOTHING happened)
     *
     * But in case of merge method, the entity that is already managed in persistence context will be
     * replaced by the new entity (updated) and a copy of this updated entity will return back.
     * (from now on any changes should be made on this returned entity if you want to reflect
     * your changes in persistence context)
     *
     * @param course
     * @param isNew
     */
    public Course save(Course course, boolean isNew)
    {
        if(isNew)
        {
            entityManager.persist(course);
            return course;
        }
        else
        {
            return entityManager.merge(course);
        }
    }

    public void delete(Long id)
    {
        Course course = find(id);
        if (course != null)
        {
            entityManager.remove(course);
        }
    }

    public void delete(Course course)
    {
        entityManager.remove(course);
    }
}
