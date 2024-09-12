package com.database.jpa.hibernate.demo.java.garbageCollection;


/**
 * Live Objects :- Which can be reachable
 * Dead objects :- Which cannot be reachable.
 *
 * Garbage collection is carried out by Daemon Thread called by Garbage Collector.
 * We cannot force gc to happen.
 *
 * When heap area is full we get OutOfMemoryError.
 *
 * @GarbageCollection Operations Involves
 *
 * Mark:
 * Start from root node of your application(main). walks the object graph, marks objects that re not reachable.
 *
 * Delete/Sweep:
 * Delete unreachable objects.
 *
 * Compacting:-
 * Compacting the memory by moving around the objects and making the allocation contiguous than fragmented.
 *
 * Java Garbage collectors are called Generational Collectors.
 * @Young generation:-(Eden Space + Survivor Space1 + Survivor Space2)
 * Where new objects are created.
 *
 * @Eden Space:- Where new objects are created.
 *
 * @Survivor Space1,2:-
 * When eden space is full. Minor GC kicks in and cleans up eden space of all unreachable objects
 * and moves all reachable objects to Survivor space.
 *
 * All the reachable objects that are moved to Survivor space1 are marked with counter indicating the
 * number of lifecycles it survived. Again when eden space is full minor gc kicks in and cleans the eden
 * space and the survivor space1 and moves the all reachable object to Survivor space2 and increment the
 * lifecycle counter by one for all reachable threads. Again if eden space is full it will clean the eden space
 * and survivor space2 and move the all reachable objects to survivor space1 incrementing the lifecycle counter.
 * This process will continue until it reaches the ThreshHold counter lifecycle. After that these objects will be
 * moved to old generation space.
 *
 *
 * @Old(Tenured) Generation:- Here major GC kicks in to clear objects.
 *
 * When old generation is near full. Major GC kicks in and performs the all operations(Mark, sweep and Compacting)
 * across all the heap area.
 *
 *
 * @TypesOfGarbageCollection
 * There are five types of garbage collection are as follows:
 *
 * @SerialGC: It uses the mark and sweeps approach for young and old generations, which is minor and major GC.
 *
 * @ParallelGC: It is similar to serial GC except that, it spawns N (the number of CPU cores in the system)
 * threads for young generation garbage collection.
 *
 * @ParallelOldGC: It is similar to parallel GC, except that it uses multiple threads for both generations.
 *
 * @ConcurrentMarkSweep (CMS) Collector: It does the garbage collection for the old generation. You can limit the
 * number of threads in CMS collector using XX:ParalleCMSThreads=JVM option. It is also known as Concurrent Low Pause
 * Collector.
 *
 * @G1GarbageCollector: It introduced in Java 7. Its objective is to replace the CMS collector. It is a parallel,
 * concurrent, and CMS collector. It divides the heap into several equal
 * sized heaps. It first collects the regions with lesser live data.
 *
 * https://www.youtube.com/watch?v=2AZ0KKeXJSo
 * https://www.youtube.com/watch?v=UnaNQgzw4zY
 * @Link https://docs.oracle.com/javase/9/gctuning/garbage-first-garbage-collector.htm#JSGCT-GUID-F1BE86FA-3EDC-4D4F-BDB4-4B044AD83180
 * @Link https://www.javatpoint.com/q/4664/can-the-unreferenced-objects-be-referenced-again
 * @Link https://www.javatpoint.com/memory-management-in-java#:~:text=In%20Java%2C%20memory%20management%20is,management%20logic%20in%20our%20application.
 *
 * https://www.freecodecamp.org/news/garbage-collection-in-java-what-is-gc-and-how-it-works-in-the-jvm/#:~:text=Parallel%20GC&text=This%20is%20the%20default%20implementation,collection%20in%20the%20Young%20Generation.
 */
public class GarbageCollection
{
    GarbageCollection gb = null;
    public static void main(String[] args)
    {
        /**
         * Below are two ways we can request GarbageCollector.
         * Even after calling below methods based on scheduler it will instantiate GC.
         */
        System.gc();
        Runtime.getRuntime().gc();
    }

    /**
     * When this object is getting garbage collected this method is called.
     *
     * This method will be called only once.
     * It will not be called once again if variable is referenced.
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable
    {
        gb=this; //We are referencing the unreferenced variable again. So it will not be garbage collected.
    }
}
