package com.database.jpa.hibernate.demo.java.Java8;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 *
 * Method reference is used to refer method of functional interface. It is compact and easy form
 * of lambda expression. Each time when you are using lambda expression to just referring a method,
 * you can replace your lambda expression with method reference.
 *
 * Sometimes, however, a lambda expression does nothing but call an existing method. In those cases,
 * it's often clearer to refer to the existing method by name. Method references enable you to do this;
 * they are compact, easy-to-read lambda expressions for methods that already have a name.
 *
 * There are following types of method references in java:
 *
 * Reference to a static method.
 * Reference to an instance method.
 * Reference to a constructor.
 *
 * Kinds of Method References
 * There are four kinds of method references:
 *
 * Kind	Example
 * Reference to a static method	ContainingClass::staticMethodName
 * Reference to an instance method of a particular object	containingObject::instanceMethodName
 * Reference to an instance method of an arbitrary object of a particular type	ContainingType::methodName
 * Reference to a constructor  ClassName::new
 *
 */
public class TestMethodReferences
{

}

interface Sayable
{
    void say();
}

class MethodReference
{
    public static void saySomething()
    {
        System.out.println("Hello, this is static method.");
    }

    public void saySomething1()
    {
        System.out.println("Hello, this is non static method.");
    }

    public int add(int a, int b){
        return a+b;
    }

    public static void main(String[] args) {
        // Referring static method
        Sayable sayable = MethodReference::saySomething;
        Sayable sayable1 = new MethodReference()::saySomething1;
        Thread t2=new Thread(MethodReference::saySomething);


        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        // Calling interface method
        sayable.say();



        BiFunction<Integer, Integer, Integer> adder = new MethodReference()::add;
        int result = adder.apply(10, 20);


        //Constructor reference.
        Messageable hello = Message::new;
        hello.getMessage("Hello");

    }

    public void testMethodReference()
    {
        Thread t1=new Thread(MethodReference::saySomething);
        Thread t2=new Thread(new MethodReference()::saySomething1);
//        Sayable sayable = MethodReference::saySomething1;

        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);

    }

}

interface Messageable
{
    Message getMessage(String msg);
}

class Message
{
    Message(String msg)
    {
        System.out.print(msg);
    }
}