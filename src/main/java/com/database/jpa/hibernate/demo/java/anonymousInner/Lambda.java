package com.database.jpa.hibernate.demo.java.anonymousInner;

/**
 * https://beginnersbook.com/2017/10/method-references-in-java-8/
 *
 * https://www.javatpoint.com/java-8-method-reference
 */
public class Lambda
{
    public static void main(String[] args) throws InterruptedException
    {
        Runnable runnable = () -> {
            int a =10;
        };
    }
}
