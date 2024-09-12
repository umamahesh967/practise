package com.database.jpa.hibernate.demo.java.multithreading;

/**
 * @Question
 * What happens when more than one thread is waiting for notification?
 * Which threads actually get the notification when the notify() method is called?
 *
 * @Answer
 * It depends on many factors.Java specification doesn’t define which thread gets notified.
 * In runtime, which thread actually receives the notification varies based on several factors,
 * including the implementation of the Java virtual machine and scheduling and timing issues during
 * the execution of the program.
 *
 * There is no way to determine, even on a single processor platform, which of multiple threads
 * receives the notification.
 *
 * Just like the notify() method, the notifyAll() method does not allow us to decide which thread
 * gets the notification: they all get notified. When all the threads receive the notification,
 * it is possible to work out a mechanism for the threads to choose among themselves which thread
 * should continue and which thread(s) should call the wait() method again.
 *
 *
 * https://howtodoinjava.com/java/multi-threading/wait-notify-and-notifyall-methods/#:~:text=%7D-,notifyAll(),notifyAll()%20method%20syntax
 */
public class NotifyAndNotifyAll {
}
