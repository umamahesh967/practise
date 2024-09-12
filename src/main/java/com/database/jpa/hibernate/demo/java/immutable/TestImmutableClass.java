package com.database.jpa.hibernate.demo.java.immutable;

/**
 *
 * Immutable objects are always thread safe. In multithreaded application even if we use immutable object it is always safe.
 *
 * Make class final, or use static factories and keep constructors private to ensure the class cannot be overridden.
 *
 * Make fields private and final to ensure the variable is not accessible from outside of class and also to
 * ensure it is not modified unknowingly in the same class from its mutator methods.
 *
 * Define parameterized constructor to initialize the state of object to ensure callers are constructing an object
 * in a single step, instead of using a no-argument constructor combined with subsequent calls to mutator methods.
 *
 * Do not provide mutator methods not to allow changes or, if we want to allow changes define mutator methods
 * but store the result in new object and return it.
 *
 *
 *
 * Ex:- String is an immutable object with mutator methods that is it allows changes on store string data
 * bit result is stored in new String object and returns that object.
 *
 * Ex:- Integer, Character and Boolean etc are immutable objects without mutator methods that is
 * they do not allow changes even new object.
 *
 * Also all primitive types are immutable by default.
 *
 * Don't add any setter method
 *
 * Declare all fields final and private
 *
 * If a field is a mutable object create defensive copies of it for getter methods
 *
 * If a mutable object passed to the constructor must be assigned to a field create a defensive copy of it
 *
 * Don't allow subclasses to override methods
 *     If a subclass override a method it can return the original value of a mutable field instead of a defensive copy of it.
 *     To solve this problem it is possible to do one of the following:
 *     Declare the immutable class as final so it can't be extended
 *     Declare all methods of the immutable class final so they can't be overridden.
 *     Create a private constructor and a factory to create instances of the immutable class because a class with private constructors can't be extended
 *
 * @Article ****
 * https://dzone.com/articles/immutable-objects-in-java#
 *
 *
 * @Usage of Immutable objects
 * An immutable object is an object that will not change its internal state after creation.
 * Immutable objects are very useful in multithreaded applications because they can be shared
 * between threads without synchronization. Immutable objects are always thread safe.
 */
public class TestImmutableClass
{
    public static void main(String... args)
    {
        Money money = new Money(23.4d);
        Immutable immutable = new Immutable("abc", money);

    }
}

class Immutable
{
    private final String string;
    private final Money money;

    public Immutable(String string, Money money) {
        this.string = string;
        this.money = new Money(money.getCost());
    }

    public String getString() {
        return string;
    }

    public Money getMoney() {
        return new Money(money.getCost());
    }
}

class Money
{
    private double cost;

    public Money(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}

