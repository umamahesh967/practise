package com.database.jpa.hibernate.demo.generalPractise;

public class A7 {
    //    static int a = m2();
    int x = m1();

    public int m1() {
        System.out.println("1");
        return 5;
    }

    protected int m2() {
        System.out.println("2");
        return 15;
    }
}
