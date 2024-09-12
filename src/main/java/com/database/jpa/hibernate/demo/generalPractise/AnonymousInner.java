package com.database.jpa.hibernate.demo.generalPractise;

import java.util.HashMap;
import java.util.Map;

public class AnonymousInner
{
    static Thread thread = new Thread(){};
    private int a =10;

    public static void main(String[] args)
    {
        int[] arr = new int[5];
        Integer[] intar;
        arr = new int[(int) 10.6];
        new Thread(){};
        m1(new Thread(){}).start();

        Map[] ab = new HashMap[5];


        Class<? extends AnonymousInner> test1Class = new AnonymousInner().getClass();
    }

    public static Thread m1(Thread t)
    {
        final int var1 = 10;
        int var2 = 15;
        Thread thread = new Thread()
        {
            private int b =10;
            public void run()
            {
                System.out.println(t);
                System.out.println(new AnonymousInner().a);
                System.out.println(var1);
                System.out.println(var2);

            }
        };
        return thread;
    }

    public void m2(Thread t)
    {
        final int var1 = 10;
        int var2 = 15;
        Thread thread = new Thread()
        {
            public void run()
            {
                System.out.println(t);
                System.out.println(a);
                System.out.println(var1);
                System.out.println(var2);

            }
        };
        thread.start();
    }
}
