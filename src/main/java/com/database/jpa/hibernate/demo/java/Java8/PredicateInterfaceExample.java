package com.database.jpa.hibernate.demo.java.Java8;

import java.util.function.Predicate;

/**
 * Java Predicate Interface
 * It is a functional interface which represents a predicate (boolean-valued function) of one argument.
 * It is defined in the java.util.function package and contains test() a functional method.
 *
 * https://www.javatpoint.com/java-predicate-interface
 */
public class PredicateInterfaceExample
{
    static Boolean checkAge(int age){
        if(age>17)
            return true;
        else return false;
    }

    public static void main(String[] args)
    {
        Predicate<Integer> pr = a -> (a > 18); // Creating predicate
        System.out.println(pr.test(10));    // Calling Predicate method

        // Using Predicate interface
        Predicate<Integer> predicate =  PredicateInterfaceExample::checkAge;
        // Calling Predicate method
        boolean result = predicate.test(25);
        System.out.println(result);
    }
}