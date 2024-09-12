package com.database.jpa.hibernate.demo.springConcepts.autowiring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * When @Autowired is used on setters, it is also equivalent to autowiring by ‘byType‘ in configuration file.
 */
@Component
public class SetterAutowiring
{
    private DepartmentBean departmentBean;

    public DepartmentBean getDepartmentBean() {
        return departmentBean;
    }

    @Autowired
    public void setDepartmentBean(DepartmentBean departmentBean) {
        this.departmentBean = departmentBean;
    }
    //More code
}