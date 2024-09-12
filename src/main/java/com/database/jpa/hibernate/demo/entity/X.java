package com.database.jpa.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class X
{
    @Id
    @GeneratedValue
    private Long xid;

    @ManyToMany
    List<Y> ylist = new ArrayList<>();

    public X() {
    }

}


