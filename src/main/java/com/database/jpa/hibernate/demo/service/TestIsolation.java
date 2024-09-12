package com.database.jpa.hibernate.demo.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@PersistenceContext
public class TestIsolation
{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void testIsolation1()
    {

    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void testIsolation2()
    {

    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void testIsolation3()
    {

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void testIsolation4()
    {

    }
}
