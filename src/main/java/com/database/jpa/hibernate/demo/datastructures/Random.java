package com.database.jpa.hibernate.demo.datastructures;

public class Random
{
    static class Node
    {
        int data;
        Node next;

//        public Node(int data, Node next)
//        {
//            this.data = data;
//            this.next = next;
//        }
    }
    public static void main(String[] args)
    {
        Integer a = new Integer(4);
        Long l= a.longValue();
        Long t = l + 1l;
//        int a =48;
        System.out.println(t);
    }
}
