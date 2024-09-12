package com.database.jpa.hibernate.demo.java.multithreading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * Perform possible asynchronous(non-blocking) computation and trigger dependent computations which
 * could also be asynchronous.
 *
 * CompletableFuture -> Non-Blocking synchronous programming model in java.
 * thenApply (Just like a stream map)
 * thenCombine (Just like stream reduce)
 * thenCompose (Just like stream flatMap)
 *
 * https://www.youtube.com/watch?v=9ueIL0SwEWI&feature=youtu.be
 * https://www.youtube.com/watch?v=ImtZgX1nmr8
 *
 * https://medium.com/swlh/completablefuture-a-simplified-guide-to-async-programming-41cecb162308
 */
class TestCompletableFuture
{

    static ExecutorService ioBound = Executors.newCachedThreadPool();
    static ExecutorService cpuBound = Executors.newFixedThreadPool(4);

    public static void main(String[] args)
    {
//        ForkJoinPool
//        ForkJoinTask
//        RecursiveTask
//       testCompletable1();
//       testCompletable2();
//        testCompletable3();

        //Working
//        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
//        completableFutures.add(CompletableFuture.runAsync(() -> async1()));
//        completableFutures.add(CompletableFuture.runAsync(() -> async2()));

        //Working
//        CompletableFuture<?>[] completableFutures1 = new CompletableFuture[3];
//        completableFutures1[1] = CompletableFuture.supplyAsync(() -> async1());
//        completableFutures1[0] = CompletableFuture.runAsync(() -> async2())
//                .thenAccept(status -> delete());
//        completableFutures1[2] = CompletableFuture.supplyAsync(() -> async4());
//
//        CompletableFuture.allOf(completableFutures1).join();

//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> async1())
//                .thenRunAsync(() -> async2());
//        CompletableFuture.allOf(voidCompletableFuture).join();

//        CompletableFuture.supplyAsync(() -> async1()).thenApplyAsync((integer) -> async2());

//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.completedFuture("Filename").supplyAsync(() -> async1())
//                .thenRunAsync(() -> async2());

//        List<CompletableFuture<Void>> completableFutures2 = new ArrayList<>();
//        List<CompletableFuture<Integer>> completableFutures1 = new ArrayList<>();
//
//        CompletableFuture<Integer> voidCompletableFuture1 = CompletableFuture.supplyAsync(() -> async1());
//        CompletableFuture<Void> voidCompletableFuture2 = CompletableFuture.runAsync(() -> async2());
//
////        completableFutures1.add(voidCompletableFuture1);
////        completableFutures2.add(voidCompletableFuture2);
//
////        CompletableFuture.allOf(voidCompletableFuture1, voidCompletableFuture2).join();
//
//        voidCompletableFuture1.join();
//        CompletableFuture.allOf(voidCompletableFuture).join();
//        System.out.println(voidCompletableFuture1.join());
        m2();
    }

    public static int async1()
    {
        for(int i=1; i<100; i++){
            System.out.println("Async1: "+i);
        }
        return 1;
    }

    public static int async4()
    {
        for(int i=1; i<100; i++){
            System.out.println("Async4: "+i);
        }
        return 1;
    }

    public static void async2()
    {
        for(int i=1; i<100; i++){
            System.out.println("Async2: "+i);
        }
        return;
    }

    public static boolean delete(){
//        try {
//            return Files.deleteIfExists(Paths.get(""));
        for(int i=1; i<100; i++){
            System.out.println("Async3: "+i);
        }
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
        return true;
    }

    public static int compute(int d)
    {
        return d * 10;
    }

    public static CompletableFuture<Integer> create(int d)
    {
        return CompletableFuture.supplyAsync(() -> compute(2));
    }

    public static void testCompletable1()
    {
        for(int i=0; i<10; i++)
        {
            CompletableFuture.supplyAsync(() -> m1()) //Here supplyAsync is Asynchronous call which will be executed in the system created threadpool(i.e ForkJoinPool).
                    .thenApply((a) -> m1()) //After getting response from above call the same thread will perform all the next thenApply operations
                    .thenApply((b) -> m1())
//                    .exceptionally(() -> ) //If we want to handle exceptions.
                    .thenAccept((c) -> m1());

            /**
             * thenApply, thenAccept the tasks can be executed by main thread also. It doesn't need to be always threads in executor threadpool.
             */
        }

    }

    public static void testCompletable2()
    {
        for(int i=0; i<10; i++)
        {
            CompletableFuture.supplyAsync(() -> m1(), ioBound) //Here supplyAsync is Asynchronous call which will be executed in the supplied threadpool.
                    .thenApplyAsync((a) -> m1(), cpuBound) //Here to execute it in supplied executor threadpool we have to use thenApplyAsync
                    .thenApplyAsync((b) -> m1(), ioBound)
                    .thenAcceptAsync((c) -> m1(), cpuBound);
        }

    }

    public static void testCompletable3()
    {
        CompletableFuture<Integer> integerCompletableFuture1 = create(2);
        CompletableFuture<Integer> integerCompletableFuture2 = create(3);

        CompletableFuture<Integer> integerCompletableFuture3 = integerCompletableFuture1.thenCombine(integerCompletableFuture2, (r1, r2) -> r1 + r2);
        CompletableFuture<CompletableFuture<Integer>> completableFutureCompletableFuture = create(4).thenApply(d -> create(d));
        CompletableFuture<Integer> integerCompletableFuture = create(4).thenCompose(d -> create(d));
    }

    public static int m1()
    {
        System.out.println(Thread.currentThread().getName());
        return 5;
    }

    public static void m2(){

        Math.ceil(7/2);
//        Arrays.copyOf()
    }
}