package com.database.jpa.hibernate.demo.java.Java8.streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.javatpoint.com/java-8-stream
 *
 * Introduced in Java 8, the Stream API is used to process collections of objects.
 * A stream is a sequence of objects that supports various methods which can be pipelined to
 * produce the desired result.
 * The features of Java stream are –
 *
 * 1.A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
 * 2.Streams don’t change the original data structure, they only provide the result as per the
 * pipelined methods.
 * 3.Each intermediate operation is lazily executed and returns a stream as a result,
 * hence various intermediate operations can be pipelined. Terminal operations mark the end
 * of the stream and return the result.
 *
 * Stream is functional in nature. Operations performed on a stream does not modify its source.
 * For example, filtering a Stream obtained from a collection produces a new Stream without the filtered
 * elements, rather than removing elements from the source collection.
 *
 * Stream is lazy and evaluates code only when required.
 *
 * The elements of a stream are only visited once during the life of a stream. Like an Iterator,
 * a new stream must be generated to revisit the same elements of the source.
 *
 *
 * Go thorough {@link java.util.function} package, you will get basic understanding of all the functions
 * like Predicate, Consumer, Function, Supplier
 */
public class Test1
{
    public static void main(String[] args)
    {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        new ArrayList<>().stream().sorted().collect(Collectors.toList());
        new ArrayList<>().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        Comparator comparator = (a, b) -> {return -1;};
        new ArrayList<>().stream().sorted(comparator).collect(Collectors.toList());

        new ArrayList<Integer>().stream().filter( a -> a != 2).collect(Collectors.toList());

        new ArrayList<Integer>().stream().filter( a -> a != 2).count();

        new ArrayList<Integer>().stream().max((a, b) -> a.compareTo(b)).get();

        new ArrayList<Integer>().stream().min((a, b) -> a.compareTo(b)).get();

        new ArrayList<Integer>().stream().map(a -> a).collect(Collectors.toList());

        Stream.of(new Integer[4]).collect(Collectors.toList()); //Return type is List<Integer>

        Stream.of(new int[4]).collect(Collectors.toList()); //Return type is List<int[]>

        Stream.of(1,2,3).collect(Collectors.toList());

        List<Integer> list = new ArrayList<>();
        int[] arr = list.stream().mapToInt(a -> a).toArray();

        List<String> listStr = new ArrayList<>();
        int[] arr1 = listStr.stream().mapToInt(Integer::parseInt).toArray();

//        Arrays.stream(new int[3]).collect(Collectors.toList());


        //https://www.geeksforgeeks.org/collectors-tomap-method-in-java-with-examples/
        Map<Integer, Integer> map = new HashMap<>();
        map.entrySet().stream().sorted(Collections.reverseOrder()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (integer, integer2) -> integer, LinkedHashMap::new));

//        Supplier

        //https://www.geeksforgeeks.org/java-8-predicate-with-examples/
        //https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/
        //https://www.geeksforgeeks.org/supplier-interface-in-java-with-examples/

    }
}
