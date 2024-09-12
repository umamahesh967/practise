package com.database.jpa.hibernate.demo.java.InterfaceVsAbstract;

/**
 * https://www.geeksforgeeks.org/interfaces-in-java/
 * https://www.geeksforgeeks.org/abstract-classes-in-java/
 * https://www.geeksforgeeks.org/difference-between-abstract-class-and-interface-in-java/
 * https://www.journaldev.com/2752/java-8-interface-changes-static-method-default-method#:~:text=Java%20interface%20static%20method%20helps,the%20instance%20method%20from%20Object%E2%80%9D.
 *
 * Form Java 8 onwards interface can have static methods and default methods.
 * Form Java 9 onwards interface can have private static methods and private instance methods.
 *
 * Abstract class vs Interface
 * @TypeOfMethods:
 * Interface can have only abstract methods. Abstract class can have abstract and non-abstract methods.
 * From Java 8, it can have default and static methods also.
 *
 * @FinalVariables:
 * Variables declared in a Java interface are by default final. An abstract class may
 * contain non-final variables.
 *
 * @TypeOfVariables:
 * Abstract class can have final, non-final, static and non-static variables. Interface has only
 * static and final variables.
 *
 * @Implementation:
 * Abstract class can provide the implementation of interface. Interface can’t provide the
 * implementation of abstract class.
 *
 * @Inheritance vs Abstraction:
 * A Java interface can be implemented using keyword “implements” and abstract class can be
 * extended using keyword “extends”.
 *
 * @Multiple Implementation:
 * An interface can extend another Java interface only,
 * an abstract class can extend another Java class and implement multiple Java interfaces.
 *
 * @Accessibility of Data Members:
 * Members of a Java interface are public by default. A Java abstract class can have class members
 * like private, protected, etc.
 *
 * https://www.geeksforgeeks.org/difference-between-abstract-class-and-interface-in-java/
 */
public class InterfaceVsAbstract
{
    public static void main(String[] args)
    {

    }
}

@FunctionalInterface
interface In1
{
    public static final int a = 10;

    public void m1();

    public static void m2()
    {

    }

    default void display()
    {
        System.out.println("hello");
    }
}


class Cls implements In1
{
    @Override
    public void m1() {
//        new Cls().m2();
        In1.m2(); //Static methods of Interface should be called with Interface name only.
    }

    public static void m3()
    {

    }

}

class Cls2 extends Cls
{
    public Cls2() {
        new Cls2().m3(); //Static methods of class can be called with class instance also.
    }
}
