package com.database.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String description;

    private String rating;

    //By default for ManyToOne mapping relation fetchType is EAGER.
    @ManyToOne
    private Course course;

    //We should always have a no argument constructor for Entity.
    public Review() {
    }

    public Review(String description, String rating) {
        this.description = description;
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("Review[%s %s]", rating, description);
    }
}
