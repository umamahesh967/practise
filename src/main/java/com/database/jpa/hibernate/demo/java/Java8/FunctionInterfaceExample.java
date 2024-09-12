package com.database.jpa.hibernate.demo.java.Java8;

import java.util.function.Function;

/**
 * https://www.javatpoint.com/java-function-interface
 *
 * https://www.javatpoint.com/java-biconsumer-interface
 */
public class FunctionInterfaceExample
{
    static String show(String message)
    {
        return "Hello "+message;
    }

    public static void main(String[] args)
    {
        // Function interface referring to a method
        Function<String, String> fun = FunctionInterfaceExample::show;
        // Calling Function interface method
        System.out.println(fun.apply("Peter"));
    }
}
