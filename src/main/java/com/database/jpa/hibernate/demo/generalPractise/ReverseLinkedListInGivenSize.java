package com.database.jpa.hibernate.demo.generalPractise;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

public class ReverseLinkedListInGivenSize
{
    public static Node reverse(Node head, int k)
    {
        if(head == null)
        {
            return head;
        }

        int i=0;
        Node current = head, prev = null;
        while(current != null && i<k)
        {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }

        head.next = reverse(current, k);
        return prev;
    }
}
