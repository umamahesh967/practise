package com.database.jpa.hibernate.demo.generalPractise;

public enum Months
{
    JAN,
    FEB;

    static
    {
        System.out.println("Static");
    }

    {
        System.out.println("Non Static");
    }

    public static void main(String[] args)
    {
        System.out.println("Main");
    }
}
