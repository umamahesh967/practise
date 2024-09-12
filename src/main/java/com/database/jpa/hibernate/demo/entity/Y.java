package com.database.jpa.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Y
{
    @Id
    @GeneratedValue
    private Long yid;

    @ManyToMany
    private List<X> xlist = new ArrayList<>();

    public Y() {
    }

    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.stream().
                filter(a-> {
                    System.out.println(a);
                    return a==a;
                }).
                forEach(b-> {
                    System.out.println(b);
                });
    }
    //output 1 1 2 2
}