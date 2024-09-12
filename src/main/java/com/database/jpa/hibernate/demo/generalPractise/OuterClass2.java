package com.database.jpa.hibernate.demo.generalPractise;

public class OuterClass2
{

    static class SInnerClass{}

    public static void main(String[] args)
    {
        SInnerClass oc = new SInnerClass(); //Creating SInnerClass object from Static Context
    }

    public void m1()
    {
        SInnerClass oc = new SInnerClass(); //Creating SInnerClass object from Non  Static Context
    }
}
