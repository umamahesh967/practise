package com.database.jpa.hibernate.demo.java.string;

/**
 * It is thread safe, mutable sequence of characters.
 * StringBuffer is like String, but can be modified in the same memory location.
 * StringBuffer class doesn't implements Comparable so cannot be compared.
 *
 * .equals() is method is not overridden in StringBuffer class.
 * so StringBuffer objects are compared with reference for both == operator and equals() method.
 *
 * If content is not fixed and keep on changing then it is recommended to not use string because for every change,
 * new object is created which effects the performance of the system.
 */
public class StringBufferHandling
{
    public static void main(String... args)
    {
        StringBuffer sb = new StringBuffer();
        sb.append('a');
        sb.append('b');
        System.out.println(sb); //ab
        System.out.println(sb.toString()); //ab
        System.out.println(sb.capacity());//16
        System.out.println(sb.length());//2

    }
}
