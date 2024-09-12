package com.database.jpa.hibernate.demo.java.string;

/**
 * String object is immutable, Synchronized.
 * String class implements Comparable
 *
 * .equals method is overridden in String class,
 * so String objects are compared with reference by using == operator and with state by using equals() method
 *
 * Since in string pool many variable are pointing to same reference. If we change the value using one string
 * referenced variable then all other referenced variables that are pointing to that object are also affected.
 * To solve this problem String is made immutable.
 *
 * String pool is for only literals not for strings created using Constructor.
 */
public class StringHandling
{
    public static void main(String... args)
    {
        System.out.println(Integer.parseInt("+011",2));

        String a = "abc"; //Creates object in string pool
        String b = "abc"; //References the already existing object in string pool.
        System.out.println(a==b);//True

        String c = new String("abc"); //Creates Object in Heap
        System.out.println(a==c);//False

        /* When the intern method is invoked, if the pool already contains a
         * string equal to this {@code String} object as determined by
         * the {@link #equals(Object)} method, then the string from the pool is
         * returned. Otherwise, this {@code String} object is added to the
         * pool and a reference to this {@code String} object is returned.
         */
        String d = new String("abc").intern();
        System.out.println(a==d);//True
        System.out.println(c==d);//False

        String test = "abcefg";

        /**
         * Concatenate the string and places in string pool area. Because it is concatenated
         * at compile time itself.
         */
        String e = "abc" + "efg";
        System.out.println(test==e);//True

        /**
         * Concatenate the string and places in Heap area. Because it is concatenated
         * at run time.
         */
        String f = a + "efg";
        System.out.println(test==a);//False

        String g = a + a;//Heap area
    }
}
