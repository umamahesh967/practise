package com.database.jpa.hibernate.demo.generalPractise;

import java.util.HashSet;
import java.util.Set;

public class FractionRepresentation
{

    private static String answer = "";
    public static void main(String[] args)
    {
        recursive(6, 22, new HashSet<>());
        System.out.println("0." + answer);
    }

    private static void recursive(int value, int divisor, Set<Integer> set)
    {
        if(set.contains(value))
        {
            value = value * 10;
            value = value / divisor;

            int index = -1;
            for(int i = answer.length()-1; i>=0; i--)
            {
                if(Character.getNumericValue(answer.charAt(i)) == value)
                {
                    index = i;
                    break;
                }
            }
            answer = answer.substring(0, index) + "(" + answer.substring(index) + ")";
            return;
        }
        else
        {
            if(value == 0)
            {
                return;
            }

            set.add(value);

            value = value * 10;
            answer += value/divisor;
            value = value % divisor;
            recursive(value, divisor, set);
        }
    }
}
