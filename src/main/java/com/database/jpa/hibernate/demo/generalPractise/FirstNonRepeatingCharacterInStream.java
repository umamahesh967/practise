package com.database.jpa.hibernate.demo.generalPractise;

import java.util.Deque;
import java.util.LinkedList;

public class FirstNonRepeatingCharacterInStream
{
    public static void main(String[] args)
    {
        String str = "jpxvxivxkkthvpqhhhjuzhkegnzqriokhsgea";

        char[] arr = new char[256];
        Deque<Character> deque = new LinkedList<>();

        for(char ch: str.toCharArray())
        {
            if(arr[ch] < 2)
            {
                if(arr[ch] == 0)
                {
                    deque.addLast(ch);
                    arr[ch]++;
                }
                else
                {
                    arr[ch]++;
                    while(!deque.isEmpty() && arr[deque.peekFirst()] > 1)
                    {
                        deque.pollFirst();
                    }

                }
            }
            if(!deque.isEmpty())
            {
                System.out.print(deque.peekFirst());
            }
            else
            {
                System.out.print(deque.peekFirst());
            }
        }
    }
}
