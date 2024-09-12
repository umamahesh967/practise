package com.database.jpa.hibernate.demo.java.multithreading.producerAndConsumer.usingBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
class ProducerAndConsumer
{
    public static void main(String[] args)
    {
        //Test BlockingQueueFactory
        BlockingFactory factory = new BlockingFactory();
        new Producer(factory).start();
        new Producer(factory).start();
        new Consumer(factory).start();

    }
}

//Since there can be multiple threads that can produce so Producer class extending Thread
class Producer extends Thread
{
    BlockingFactory factory;
    public Producer(BlockingFactory factory)
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
    BlockingFactory factory;
    public Consumer(BlockingFactory factory)
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

//Producer Consumer Pattern using BlockingQueue
class BlockingFactory
{
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public void produce(int i)
    {
        try
        {
            queue.put(i);
            Thread.sleep(1);
            System.out.println("Produced Values: "+i);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    public void consume()
    {
        try
        {
            System.out.println("Consumed Values: "+queue.take());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

