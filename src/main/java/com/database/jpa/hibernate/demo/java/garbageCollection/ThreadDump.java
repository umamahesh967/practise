package com.database.jpa.hibernate.demo.java.garbageCollection;

/**
 * A thread dump is a snapshot of the state of all the threads of a Java process.
 *
 * @jstack
 * jstack is a command-line JDK utility we can use to capture a thread dump. I
 * t takes the pid of a process and displays the thread dump in the console. Alternatively, we can redirect its output to a file.
 * Let's take a look at the basic command syntax for capturing a thread dump using jstack:*
 * jstack [-F] [-l] [-m] <pid>
 *
 *
 * @jvisualvm
 * jvisualvm is a tool with a graphical user interface that lets us monitor, troubleshoot, and profile Java applications.
 * The GUI is simple, but very intuitive and easy to use.
 * One of its many options allows us to capture a thread dump. If we right-click on a Java process and select the “Thread Dump” option,
 * the tool will create a thread dump and open it in a new tab:
 *
 * https://www.baeldung.com/java-thread-dump
 *
 * Run DeadLockDemoStatic.java file and start visualVm from JDK, when you click on heap dump on visualVM you can see which
 * threads are in deadlock and also the state of other threads(Whether we are in Running or Blocking or Runnable state.)
 * https://www.youtube.com/watch?v=Uubqc76h-jo
 *
 *
 * @jconsole
 * jconsole lets us inspect the stack trace of each thread. If we open jconsole and connect to a running Java process,
 * we can navigate to the Threads tab and find each thread's stack trace
 */
public class ThreadDump {
}
