package com.database.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Test
{
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
//                (targetEntity = Course.class, mappedBy ="tst" )
    @JoinColumns({
            @JoinColumn(name = "TEST_DDG", referencedColumnName = "id")
             })
    List<Course> course = new ArrayList<>();

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public Test() {
    }
}
