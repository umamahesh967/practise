package com.database.jpa.hibernate.demo.java.string;

import java.io.Serializable;
import java.util.Arrays;

public class StringSplit
{
    public static void main(String[] args)
    {
        String[] strings = new String[]{"9","90"};
        Arrays.sort(strings);

        String str = "I\n.like.you";
        System.out.println(str);

        String[] stra = str.split("\\.");
        str = String.join(".", stra);

        System.out.println("String: "+str);
    }
}

abstract class A
{
    static final short a=10;
}