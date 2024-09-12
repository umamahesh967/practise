package com.database.jpa.hibernate.demo.springConcepts.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * When @Autowired is used on properties, it is equivalent to Autowiring by ‘byType‘ in configuration file.
 *
 * @Primary
 * If we are Autowiring and if we have multiple implementations of same Class/Interface then for whichever class
 * implementation we need. we can declare @Primary on that class.
 *
 * https://udemy.com/course/spring-tutorial-for-beginners/learn/lecture/7725720#overview
 *
 *
 */

@Component
public class PropertyAutowiring
{
    @Autowired
    private DepartmentBean departmentBean;

    @Autowired
    @Qualifier("child2")
    private Parent parent;

    public DepartmentBean getDepartmentBean()
    {
        return departmentBean;
    }
    public void setDepartmentBean(DepartmentBean departmentBean)
    {
        this.departmentBean = departmentBean;
    }
}


@Component
interface Parent
{

}

@Component
//@Primary   //If you want this to autowired for Parent then we use @Primary
class Child1 implements Parent{

}

@Component
@Qualifier("child2")
class Child2 implements Parent{

}