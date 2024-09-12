package com.database.jpa.hibernate.demo.generalPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2
{
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1,2,3,5));
        list.add(Arrays.asList(6,7,8,8));
        list.add(Arrays.asList(1,2,3,5));
        DoubleIterator<Integer> doubleIterator = new DoubleIterator<>(list);
        while (doubleIterator.hasNext())
        {
            System.out.println(doubleIterator.next());
        }

    }

}

