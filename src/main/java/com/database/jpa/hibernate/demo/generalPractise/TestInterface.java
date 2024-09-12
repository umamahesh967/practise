package com.database.jpa.hibernate.demo.generalPractise;

public interface TestInterface
{
    public void m1();

    public static void m2(){

    }

    default void m3()
    {

    }
}

interface A extends TestInterface
{

}

abstract class B implements A{
    @Override
    public abstract void m1();

}

class C extends B{
    @Override
    public void m1() {

    }
}
