package com.database.jpa.hibernate.demo.java.multithreading;

/**
 * When two threads are accessing same variable.
 *
 * If thread1 makes some modifications to variable. Those changes to the variable should
 * be reflected in thread2. But that does not happen.
 *
 * Because each thread has cache. When thread1 makes changes those are made in thread1 cache not in shared cache.
 * To make those changes reflect immediately in shared cache we use volatile.
 *
 * So volatile solves the visibility problem.
 *
 * https://www.geeksforgeeks.org/volatile-keyword-in-java/
 * https://www.youtube.com/watch?v=WH5UvQJizH0&t=1s
 */
public class Volatile {
}
