package com.database.jpa.hibernate.demo.java.multithreading;

/**
 *
 * @Differences Between Lock and Synchronized Block
 * There are few differences between the use of synchronized block and using Lock API's:
 *
 * 1.A synchronized block is fully contained within a method – we can have Lock API's lock()
 *  and unlock() operation in separate methods
 *
 * 2.A synchronized block doesn't support the fairness, any thread can acquire the lock once released,
 *  no preference can be specified. We can achieve fairness within the Lock APIs by specifying
 *  the fairness property. It makes sure that longest waiting thread is given access to the lock
 *
 * 3.A thread gets blocked if it can't get an access to the synchronized block.
 *  The Lock API provides tryLock() method. The thread acquires lock only if it's available and
 *  not held by any other thread. This reduces blocking time of thread waiting for the lock
 *
 * 4.A thread which is in “waiting” state to acquire the access to synchronized block,
 *  can't be interrupted. The Lock API provides a method lockInterruptibly() which can
 *  be used to interrupt the thread when it's waiting for the lock
 *
 * https://www.baeldung.com/java-concurrent-locks#:~:text=It%20makes%20sure%20that%20longest,held%20by%20any%20other%20thread.
 */
public class SynchronizedAndLock {
}
