package com.database.jpa.hibernate.demo.java.multithreading;

/**
 * The process can be referred as program in execution whereas thread is part of process.
 *
 * Process has its own address space whereas multiple threads share same address space of
 * process. Each thread has its own stack.(Assume JVM Architecture where we create multiple threads
 * in Java stack Area and each thread has access to Method area, Heap Area, Native method area
 * but doesn't have access to Stack Frame(For each thread we create separate stack frame))
 *
 * Thread is also called as Light-weight process, as it present in same address block as the Process
 * and shares the code,data and the OS resources of the process with fellow threads.It cost less
 * resources to communicate between the threads.
 *
 * Heavy-weight process defines the processes running parallel to accomplish their tasks.Every process
 * has their own data,code and OS resources and the processes requires extra resources to communicate
 * between themselves.
 * https://stackoverflow.com/questions/6004069/lightweight-vs-heavyweight-processes#:~:text=Thread%20is%20also%20called%20as,to%20communicate%20between%20the%20threads.
 *
 *
 * Process are quite heavyweight and have more overhead whereas thread is light weight and have less overhead.
 *
 * Process do not depend on each other whereas threads are not independent as they share address space
 *
 * You do not require synchronization in case of process. Threads require synchronization to avoid unexpected scenarios.
 *
 * You can easily create new threads by calling thread’s start method but you need to copy resources of parent process
 * to create a new child process.
 *
 * https://stackoverflow.com/questions/1762418/what-resources-are-shared-between-threads#:~:text=There%20is%20one%20address%20space,equal%20access%20to%20that%20object.
 *
 */
public class ThreadVsProcess {
}
