package com.database.jpa.hibernate.demo.datastructures.bitwise;

public class ConvertBinaryToDecimal
{
    public static void main(String... args)
    {
        System.out.println(Integer.parseInt("1001",2));//Binary to Decimal
        System.out.println(Integer.parseInt("00f",16));//Hex to Decimal
        System.out.println(Integer.parseInt("10f",16));//Hex to Decimal
        System.out.println(Integer.parseInt("-011",2));
    }
}
