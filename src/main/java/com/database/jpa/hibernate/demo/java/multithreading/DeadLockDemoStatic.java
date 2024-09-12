package com.database.jpa.hibernate.demo.java.multithreading;

//Static way of creating DeadLock

/**
 * Ways to avoid DeadLock
 * 1.Avoid Nested Locks :
 *   This is the main reason for dead lock. Dead Lock mainly happens when we give locks to multiple threads.
 *   Avoid giving lock to multiple threads if we already have given to one. Avoid like writing below piece of code.
 *       synchronized(obj1){
 *              ...//blah
 *          synchronized(obj2){
 *                ...//blah
 *          }
 *       }
 *
 *
 * 2.void Unnecessary Locks : Below example is this kind.
 *   We should have lock only those members which are required. Having lock on unnecessarily
 *   can lead to dead lock.
 *
 * 3. Using thread join :
 *   Dead lock condition appears when one thread is waiting other to finish.
 *   If this condition occurs we can use Thread.join with maximum time you think the execution will take.
 *
 *
 *   Ways tp prevent deadLock
 *   1.DeadLocks occur when a thread is waiting for a lock held by other thread and vice-versa.
 *   2.Detect at runtime using thread dumps.
 *   3.Consistent ordering of lock acquisition helps avoid deadlock.
 *   4.Using timeouts for lock acquisition can also help.
 *
 *
 *
 */
public class DeadLockDemoStatic extends Thread
{
    static M1 m1 = new M1();
    static C1 c1 = new C1();
    public DeadLockDemoStatic() throws InterruptedException
    {

    }

    @Override
    public void run()
    {
        try {
            c1.c1(m1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        DeadLockDemoStatic demo = new DeadLockDemoStatic();
        demo.start();

        m1.m1(c1);
    }
}

class DeadLockDemoNonStatic extends Thread
{
    M1 m1 = new M1();
    C1 c1 = new C1();
    public DeadLockDemoNonStatic() throws InterruptedException
    {
        Thread thread = new Thread(this);
        thread.start();
        m1.m1(c1);
    }

    @Override
    public void run()
    {
        try {
            c1.c1(m1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        DeadLockDemoNonStatic demo = new DeadLockDemoNonStatic();
        demo.start();
    }
}

class M1
{
    public synchronized void m1(C1 c1) throws InterruptedException {
        System.out.println("In Thread");
        Thread.sleep(1000);
        c1.c2();
        System.out.println("Out Thread");
    }

    public synchronized void m2()
    {

    }
}

class C1
{
    public synchronized void c1(M1 m1) throws InterruptedException {
        Thread.sleep(1000);
        m1.m2();
    }

    public synchronized void c2()
    {

    }
}