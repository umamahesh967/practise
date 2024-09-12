package com.database.jpa.hibernate.demo.java.equalsAndHashcodeContract;

import java.util.HashMap;
import java.util.Objects;


/**
 * Contract
 * 1.If two objects are equal(according to equals() method) then the hashCode() method should return
 * the same integer value for both the objects.
 *
 * 2.If two objects are not equal then hashcode method may return same or different integer value.
 *
 */
public class TestEqualsAndHashCodeContract
{
    public static void main(String[] args)
    {
        HashMap<Employee, Integer> map = new HashMap<>();
        Employee employee1 = new Employee(2, "mahesh");
        Employee employee2 = new Employee(2, "mahesh");

        map.put(employee1, 3);
        System.out.println(employee1.hashCode() == employee2.hashCode());
        System.out.println(employee1.equals(employee2));
        System.out.println(map.get(employee2));

    }
}

class Employee
{
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        o.hashCode();
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
//        return Objects.hash(id, name);
        return id + name.hashCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}