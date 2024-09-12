package com.database.jpa.hibernate.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries(
    value = {
        @NamedQuery(name = "query_get_all_courses", query="Select c from Course c"),
        @NamedQuery(name = "query_get_100_Step_courses", query="Select c from Course c where name like '%50 Steps'")
    }
)
//@Table(name = "CourseDetails") //If we want to give custom defined table name or else it will be Class Name.
//@Cacheable //Retrieved from 2nd level cache
public class Course
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @ManyToMany(mappedBy = "courses") //https://udemy.com/course/hibernate-jpa-tutorial-for-beginners-in-100-steps/learn/lecture/7907556#overview
    @JsonIgnore //If you want to ignore a specific field from being returned back in course json then use JsonIgnore.
    private List<Student> students = new ArrayList<>();

    //By default for OneToMany mapping relation fetchType is Lazy.
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();

    @Column(name = "TEST_DDG")
    private Long testPk;

    //We should always have a no argument constructor for Entity.
    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReviews(Review review) {
        this.reviews.remove(review);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    @Override
    public String toString() {
        return String.format("Course[%s]", name);
    }
}
