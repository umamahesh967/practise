package com.database.jpa.hibernate.demo.generalPractise;

class B7 extends A7 implements Cloneable{
//    static int b = m2();
    int y =m1();
    String s1 = new String("kvk");
    public int m1()
    {
        System.out.println("3");
        m2();
        return 10;
    }

    public static int  m3()
    {
        System.out.println("4");
        return 20;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class Test4
{
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        B7 b1 = new B7();
        B7 b2 = (B7) b1.clone();
//        A7 a1 = new B7();
        new A7().m2();
        System.out.println(b1.x);
        System.out.println(b1.y);

//        System.out.println(a1.x);
//        System.out.println(a1.x);


    }
}
