package com.database.jpa.hibernate.demo.java.multithreading.producerAndConsumer.synchronizedFactory;

import java.util.LinkedList;
import java.util.Queue;

class ProducerAndConsumer
{
    public static void main(String[] args)
    {
        //Test LockFactory
        SynchronizedFactory factory1 = new SynchronizedFactory();
        new Producer(factory1).start();
        new Producer(factory1).start();
        new Consumer(factory1).start();
        new Consumer(factory1).start();
    }
}

//Since there can be multiple threads that can produce so Producer class extending Thread
class Producer extends Thread
{
    SynchronizedFactory factory;
    public Producer(SynchronizedFactory factory)
    {
        this.factory = factory;
    }


    @Override
    public void run() {
        for(int i=0; i<10; i++)
        {
            factory.produce(i);
        }
    }
}

//Since there can be multiple threads that can consume so Consumer class extending Thread
class Consumer extends Thread
{
    SynchronizedFactory factory;
    public Consumer(SynchronizedFactory factory)
    {
        this.factory = factory;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++)
        {
            factory.consume();
        }
    }
}

//Both Producer threads and Consumer threads acts on Factory class
//Using Old fashioned Synchronization wait and notify methods
class SynchronizedFactory
{
    Queue<Integer> queue = new LinkedList<>();

    public synchronized void produce(int i)
    {
        try {
            while (!queue.isEmpty()) //
            {
                wait();
            }

            System.out.println("Produced Values: "+i);
            queue.add(i);
            notifyAll(); // or  notify() if you want wake up only one thread.
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    public synchronized void consume()
    {
        try {
            while (queue.isEmpty()) //We are adding while because, if we have multiple threads trying to consume
                //but we have only single producer, after producer producing single item it will call notifyall,
                //now all the consumer threads go into ready state from waiting state. Now each and every consumer thread
                //gets lock one after one but only first consumer thread will get value and all consumer threads get
                // null value because queue is empty. Similar scenario applies for Producer while loop.
                //Also this while loop is required only if we use notifyAll()
                //We don't require while loop if we call notify(), because only one consumer will come out from wait here.
            {
                wait();
            }

            System.out.println("Consumed Values: "+queue.poll());
            System.out.println("Size Values: "+queue.size());
            notifyAll(); // or  notify() if you want wake up only one thread.
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
