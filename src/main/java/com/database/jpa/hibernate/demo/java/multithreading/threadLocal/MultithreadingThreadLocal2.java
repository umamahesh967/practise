package com.database.jpa.hibernate.demo.java.multithreading.threadLocal;


public class MultithreadingThreadLocal2
{
    //If I want to pass a context to multiple services
    public static void main(String[] args)
    {
        new Service1().m1();
    }
}


class Service1
{
    //If we set context in m1() method we can use in all the service methods
   public void m1()
   {
       Context context = new Context("Mahesh"); // Here we can get the context from DB or create a new context
       UserContextHolder.contextHolder.set(context);
       System.out.println(UserContextHolder.contextHolder.get().getName());
       new Service2().m2();
   }
}

class Service2
{
    public void m2()
    {
        System.out.println(UserContextHolder.contextHolder.get().getName());
        UserContextHolder.contextHolder.remove();
        System.out.println(UserContextHolder.contextHolder.get());
    }
}


class UserContextHolder
{
    public static ThreadLocal<Context> contextHolder = new ThreadLocal<>();
}

class Context
{
    String name;

    public Context(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "temp";
    }
}
