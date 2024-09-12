package com.database.jpa.hibernate.demo.java.multithreading;

/**
 * Synchronization Problem(Print odd and Even numbers in different thread) but in synchronized manner
 *   Thread1 1 3 5 7 9
 *   Thread2 2 4 6 8 10
 *
 *   Output should be printed in 1 2 3 4 5 6 7 8 9 10
 *
 *   https://www.geeksforgeeks.org/print-even-and-odd-numbers-in-increasing-order-using-two-threads-in-java/
 *
 */
public class Print1To10Numbers
{
    private static int number = 1;

    public void printOddNumbers()
    {
        synchronized (this)
        {
            while(number <10)
            {
                if (number % 2 == 0)
                {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd Number:"+number);

                number++;
                notify();
            }
        }
    }

    public void printEvenNumbers()
    {
        synchronized (this)
        {
            while(number < 10)
            {
                if (number % 2 == 1)
                {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Even Number:"+number);

                number++;
                notify();
            }
        }
    }

    public static void main(String[] args)
    {
        Print1To10Numbers print1To10Numbers = new Print1To10Numbers();
//        Runnable runnable = print1To10Numbers::printOddNumbers;

        new Thread(print1To10Numbers::printEvenNumbers).start();
        print1To10Numbers.printOddNumbers();
//        new Thread(print1To10Numbers::printOddNumbers).start();
    }
}
