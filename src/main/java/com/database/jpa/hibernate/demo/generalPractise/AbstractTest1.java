package com.database.jpa.hibernate.demo.generalPractise;

public abstract class AbstractTest1
{
    static
    {
        System.out.println("SB");
    }

    {
        System.out.println("NSB");
    }

    public static void main(String[] args)
    {
        System.out.println("Main");
        Months months = null;

        Months.JAN.name();

    }

}


