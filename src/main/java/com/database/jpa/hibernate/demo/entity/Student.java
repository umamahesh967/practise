package com.database.jpa.hibernate.demo.entity;

//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;


    //This is the owning side of the passport.
    //By default for OneToOne mapping relation fetchType is EAGER.
    @OneToOne(fetch = FetchType.LAZY) // Lazy fetch the passport details, doesn't fetch the passport details for student until
    //we explicitly call student.getPassport() in transaction.
    private Passport passport;


    /**
     * Above passport is stored in separate table.
     *
     * If we want to store all the fields of Address in the Course table. then we need to use @Embedded.
     * So Course table will have line1, line2, city columns instead of AddressId field.
     */
    @Embedded
    private Address address;


    //By default for ManyToMany mapping relation fetchType is LAZY.
    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",   //https://udemy.com/course/hibernate-jpa-tutorial-for-beginners-in-100-steps/learn/lecture/7907558#overview
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
    )
    private List<Course> courses = new ArrayList<>();


    //We should always have a no argument constructor for Entity.
    public Student() {
    }

    public Student(String name) {
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

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //    @Override
//    public String toString() {
//        return String.format("Student[%s]", name);
//    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passport=" + passport +
                ", courses=" + courses +
                '}';
    }
}
