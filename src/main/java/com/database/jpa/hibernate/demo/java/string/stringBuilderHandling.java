package com.database.jpa.hibernate.demo.java.string;


/**
 * StringBuilder is non thread safe, mutable sequence of characters.
 * StringBuilder is like StringBuffer, only difference is it is not thread safe.
 * StringBuilder class doesn't implements Comparable so cannot be compared.
 *
 * .equals() is method is not overridden in StringBuilder class.
 * so StringBuilder objects are compared with reference for both == operator and equals() method.
 */
public class stringBuilderHandling
{
    public static void main(String... args)
    {
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        sb.append('b');
        System.out.println(sb); //ab
        System.out.println(sb.toString()); //ab
        System.out.println(sb.capacity());//16
        System.out.println(sb.length());//2
    }
}