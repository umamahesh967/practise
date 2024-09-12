package com.database.jpa.hibernate.demo.generalPractise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

public class Test1
{
    final int b;

    public Test1(int b) {
        this.b = b;
    }

    public static void main(String[] args)
    {
////        List<Course> courses = new ArrayList<>();
////        Course course1 = new Course();
////        course1.setName("1");
////        course1.addStudent(new Student());
////        courses.add(course1 );
////
////        Course course2 = new Course();
////        course2.setName("1");
////        Student student = new Student();
////        student.setName("Mahesh");
////        course2.addStudent(student);
////        courses.add(course2 );
////
//////        System.out.println(courses.stream().collect(Collectors.toMap(course -> course.getName(), course -> course)));
////
////        System.out.println(courses.stream().collect(Collectors.toMap(course -> course.getName(), course -> course, (course, course3) -> course3)));
////        Map<String, Course> map = courses.stream().collect(Collectors.toMap(course -> course.getName(), Function.identity(),
////                (course, course3) -> course3, TreeMap::new));
////
////        Map<Integer, Integer> map1 = new TreeMap<>();
////        map1.put(50,50);
////        map1.put(5,5);
////        map1.put(3,3);
////        map1.put(20,20);
////        map1.put(1,1);
////        map1.put(40,40);
//////        System.out.println(map1.values().);
////        StringBuilder stringBuilder = new StringBuilder();
////        Integer a =4;
////        stringBuilder.append(a);
////
//        Map<Integer, Integer> map2 = new LinkedHashMap<>();
//        map2.put(3, 3);
//        map2.put(4, 4);
//        map2.put(2, 2);
//        map2.put(1, 1);
//        map2.put(4, 10);
//        map2.remove(2);
//        System.out.println(map2);
//
////        Double d = 0.0;
////        if(d>0)
////        {
////            System.out.println("Yaay");
////        }
        Map<String, Double> map = new HashMap();
        ArrayDeque<Integer> arrayDeque;

        final int a;
        a =10;
//        b =20;
//        populate(map);
//        System.out.println(map);
//
////        Comparator<Map.Entry<String, Double>> comparator = (a, b) -> {
////            if(a.getValue() == 0 && b.getValue() == 0)
////            {
////                return 0;
////            }
////            else if(a.getValue() == 0)
////            {
////                return -1;
////            }
////            else if(b.getValue() == 0)
////            {
////                return 1;
////            }else
////            {
////                return a.getValue().compareTo(b.getValue());
////            }
////        };
////
////
////

////
//        System.out.println(map);

////        StringBuilder sb = new StringBuilder();
////
//        String string = "https://tpestg.logistics.com:443/services/rest/cbotrans/cbodocument-webservice/downloadDocument?objectId=61384482&amp;objectType=SHIP&amp;docId=270749&amp;docType=530&amp;revNo=1&amp;docFileName=Test 2.pdf";
//        String[] arr = string.split("\\s+");
////
////        string.replaceAll("\\s+", "+");
////        System.out.println(string.replaceAll("\\s+", "+"));
////
////        sb.append("revNo=").append("&")
////                .append("docFileName=").append(string);
////        System.out.println(sb.toString());
//
//        boolean[] a = new boolean[256];
//        char ch = 'a';
//        a[ch] = true;

//        int a = 12;
//        int b = a & (1 << 1);
//        int count =0;
//        while(b > 0)
//        {
//            b = b>>1;
//            count++;
//        }
//        for (int i = 0; i < ; i++) {
//
//        }

        int xor = 0;
        int sum = 8;
        int[] arr = new int[5];
        Deque<Integer> deque = new LinkedList<>();
        int k =3;
        for (int i = 0; i <k ; i++)
        {
           if(deque.isEmpty())
           {
               deque.add(i);
           }
           else
           {
               if(arr[i] < arr[deque.peekLast()])
               {
                   deque.add(i);
               }
               else
               {
                   while(arr[deque.peekLast()] < arr[i])
                   {
                       deque.pollLast();
                   }
                   deque.add(i);
               }
           }
        }
//        System.out.println(arr[deque.peekFirst()]);

//        for(int i = k; i< arr.length; i++)
//        {
//            if(arr[deque.peekLast()] > arr[i] )
//            {
//                deque.add(i);
//            }
//            else
//            {
//                while(arr[deque.peekLast()] <= arr[i])
//                {
//                    deque.pollLast();
//                }
//                deque.add(i);
//            }
//
//            while(i-k >= deque.peekFirst())
//            {
//                deque.pollFirst();
//            }
//            System.out.println(arr[deque.peekFirst()]);
//        }

//        for (int j=1; j<=3; j++)
//        {
//            sum = sum << 1;
//        }
//        System.out.println((sum & (sum-1)) == 0);

//        int value =17;
//        for (int i = 2; i <=3; i++) {
//            value = value ^ sum;
//            sum = sum <<1;
//        }
//        System.out.println(value);
//        String[] strings = "a.b.c.d".split(".");
//
//        "a".concat("."+strings[0]);
//
//        char ch = 'a'+2-1;
        System.out.println("a   b".replaceAll(" ", "+"));

//        Double a = (double) 10.2;
//        float f = a.floatValue();
//        int a=1;
        byte vh = -128;
        char ch = (char) vh;
        short dg = (short) ch;
        long bh = 78l;
        float fg = bh;
        double yh = bh;

        Integer at = 20;
        System.out.println("sfs"+a);
        System.out.println("sfs"+at);


        List list = new LinkedList();


//        Stack stack = (Stack) list;
//        byte cdc = vh + vh;
    }

    private static void populate(Map<String, Double> map1)
    {
//        new String(new char[2]);
//        map.put("e", -9.0);
//        map.put("f", 4.0);
//        map.put("a", 5.0);
//        map.put("c", -1.0);
//        map.put("d", 0.0);
//        map.put("b", 0.0);
//        map.put("g", 0.0);
//
//        Comparator<Double> comparator = null;
//        map = map.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(comparator))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//
//        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
//        map1.put(5,3);
//        map1.put(2,2);
//        map1.put(10,10);
//        map1 = map1.entrySet().stream().sorted(Map.Entry.comparingByKey())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap :: new ));
//        System.out.println(map);

        Comparator<Integer> comp = (a, b) -> {
            return a.compareTo(b);
        };


        Integer[] arr = new Integer[5];
        // Collections.sort(arr);
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<Integer>();
        // list.stream().map(a -> a).collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(5,3);
        map.put(2,2);
        map.put(10,10);
        map = map.entrySet().stream().sorted(Map.Entry.comparingByKey(comp))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap :: new ));

    }

}
