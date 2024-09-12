package com.database.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    //By default for OneToOne mapping relation fetchType is EAGER.
    @OneToOne(fetch= FetchType.LAZY, mappedBy="passport") //mappedBy meaning student is owing the relationship, we mention mappedBy not in owning entity but in other entity
    private Student student;

    //We should always have a no argument constructor for Entity.
    public Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return String.format("Passport[%s]", number);
    }
}
