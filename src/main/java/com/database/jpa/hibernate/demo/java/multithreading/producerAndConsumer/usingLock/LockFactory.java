package com.database.jpa.hibernate.demo.java.multithreading.producerAndConsumer.usingLock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://www.youtube.com/watch?v=UOr9kMCCa5g
 */
class ProducerAndConsumer
{
    public static void main(String[] args)
    {
        //Test LockFactory
        LockFactory factory1 = new LockFactory();
        new Producer(factory1).start();
        new Producer(factory1).start();
        new Consumer(factory1).start();
    }
}

//Since there can be multiple threads that can produce so Producer class extending Thread
class Producer extends Thread
{
    LockFactory factory;
    public Producer(LockFactory factory)
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
    LockFactory factory;
    public Consumer(LockFactory factory)
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

//Using Locks
class LockFactory
{
    Queue<Integer> queue = new LinkedList<>();
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    int max = 10;

    public synchronized void produce(int i)
    {
        lock.lock();
        try
        {
            while(queue.size() == max) //Why we are adding while here we can understand this in the video above.
            {
                condition1.await(); //Block until queue has atleast one empty slot to add item.
            }
            System.out.println("Produced Values: " + i);
            queue.add(i);
            condition2.signalAll(); // or  condition2.signal()
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public synchronized void consume()
    {
        lock.lock();
        try {
            while (queue.isEmpty()) //Why we are adding while here we can understand this in the video above.
            //We are adding while because, if we have multiple threads trying to consume
            //but we have only single producer, after producer producing single item it will call notifyall,
            //now all the consumer threads go into ready state from waiting state. Now each and every consumer thread
            //gets lock one after one but only first consumer thread will get value and all consumer threads get
            // null value because queue is empty. Similar scenario applies for Producer while loop.
            {
                condition2.await(); //Block until queue has atleast one item to take
            }

            System.out.println("Consumed Values: "+queue.poll());
            condition1.signalAll(); // or  condition1.signal()
            //By using fairness(true) in ReentrantLock, longest waiting thread will get the lock in this scenario.
            //By using fairness(false) in ReentrantLock, any waiting thread will get the lock in this scenario.

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}
