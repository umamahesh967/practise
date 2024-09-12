package com.database.jpa.hibernate.demo.jpql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JPQLNamedTest
{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;

    public void jpqlNamed_basic() {
        Query query = entityManager.createNamedQuery("query_get_all_courses");
        List resultList = query.getResultList();
        logger.info("select c from Course c -> {}", resultList);
    }

    public void jpqlNamed_basic2() {
        Query query = entityManager.createNamedQuery("query_get_100_Step_courses");
        List resultList = query.getResultList();
        logger.info("select c from Course c -> {}", resultList);
    }
}
