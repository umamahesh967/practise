package com.database.jpa.hibernate.demo.springConcepts.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * When @Autowired is used on bean’s constructor, it is also equivalent
 * to autowiring by ‘constructor‘ in configuration file.
 */
@Component
public class ConstructorAutowiring
{
    private DepartmentBean departmentBean;

    @Autowired
    public ConstructorAutowiring(DepartmentBean departmentBean)
    {
        this.departmentBean = departmentBean;
    }

    public DepartmentBean getDepartmentBean() {
        return departmentBean;
    }
    public void setDepartmentBean(DepartmentBean departmentBean) {
        this.departmentBean = departmentBean;
    }
    //More code
}