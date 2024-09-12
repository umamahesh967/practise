package com.database.jpa.hibernate.demo.generalPractise;

public class OuterClass
{

    class NSInnerClass{}

    public static void main(String[] args)
    {
        NSInnerClass oc = new OuterClass().new NSInnerClass(); //Creating NSInnerClass object from Static Context
    }

    public void m1()
    {
        new NSInnerClass(); //Creating NSInnerClass object from Non Static Context.
    }
}
