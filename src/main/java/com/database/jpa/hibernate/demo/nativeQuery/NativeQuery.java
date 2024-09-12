package com.database.jpa.hibernate.demo.nativeQuery;

import com.database.jpa.hibernate.demo.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

//One of the things we need to keep in mind is that whenever we are using native queries we are not using persistence context
@Repository
public class NativeQuery
{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public void nativeQuery_basic() {
        Query query = entityManager.createNativeQuery("select * from course");
        List resultList = query.getResultList();
        logger.info("select * from course -> {}", resultList);
    }

    public void nativeQuery_basic2() {
        Query query = entityManager.createNativeQuery("select * from course", Course.class);
        List resultList = query.getResultList();
        logger.info("select * from course -> {}", resultList);
    }

    public void nativeQuery_parameterPosition_basic3() {
        Query query = entityManager.createNativeQuery("select * from course where id=?", Course.class);
        query.setParameter(1, 10001L);
        List resultList = query.getResultList();
        logger.info("select * from course -> {}", resultList);
    }

    public void nativeQuery_namedParameter_basic4() {
        Query query = entityManager.createNativeQuery("select * from course where id = :id", Course.class);
        query.setParameter("id", 10001L);
        List resultList = query.getResultList();
        logger.info("select * from course -> {}", resultList);
    }

    @Transactional
    public void nativeQuery_update() {
        Query query = entityManager.createNativeQuery("update course set last_updated_date=sysdate()");
        int noOfRows = query.executeUpdate();
        logger.info("updated rows -> {}", noOfRows);
    }
}
