package com.database.jpa.hibernate.demo.springConcepts.autowiring;

import org.springframework.stereotype.Component;

@Component
public class DepartmentBean{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
