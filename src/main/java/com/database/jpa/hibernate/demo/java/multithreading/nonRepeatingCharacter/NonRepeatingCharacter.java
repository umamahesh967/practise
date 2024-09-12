package com.database.jpa.hibernate.demo.java.multithreading.nonRepeatingCharacter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NonRepeatingCharacter extends Thread
{
    static Map<Character, Integer> finalMap = new HashMap<>();

    public static void main(String[] rags) throws ExecutionException, InterruptedException {
        String string = "hrevygubhjygecvhhbjhygvhbnjuiyghvbnjkijuhhbnmkiuhhgvmkjiuhh bmklhb mkhhvgb mkiuhgvb nkmijugv bnkjhgvb njkhgvb njjigv bnjkjgvh bnkjigv bmkgv bmkjihhbb mkluhgv";

        ExecutorService service1 = Executors.newFixedThreadPool(1);
        long time = System.currentTimeMillis();
        Future<Map<Character, Integer>> future1 = service1.submit(new PopulateMap(string));
        System.out.println("Single Thread Time: "+(System.currentTimeMillis() - time));
        System.out.println(future1.get());
        System.out.println("Single Thread Time: "+(System.currentTimeMillis() - time));

        System.out.println("Started Multiple Thread");
        //Multiple thread
        ExecutorService service = Executors.newFixedThreadPool(4);
        int dividedLength = string.length() /4;
        int start = 0;
        List<Future<Map<Character, Integer>>> futures = new ArrayList<>();
        time = System.currentTimeMillis();
        for(int i = 0; i< 4; i++)
        {
            Future<Map<Character, Integer>> future;
            if(i == 3)
            {
                future = service.submit(new PopulateMap(string.substring(start)));
            }
            else
            {
                future = service.submit(new PopulateMap(string.substring(start, start + dividedLength)));
            }
            futures.add(future);
            start = start + dividedLength;
        }
        System.out.println("Multiple Thread Time: "+(System.currentTimeMillis() - time));

        for(Future<Map<Character, Integer>> future2: futures)
        {
            addToMap(future2.get());
        }

        System.out.println("Multiple Thread Time: "+(System.currentTimeMillis() - time));
        System.out.println(finalMap);

        for(Character character : string.toCharArray())
        {
            if(finalMap.containsKey(character) && finalMap.get(character) == 1)
            {
                System.out.println("Non repeating character: "+character);
                break;
            }
        }


    }

    private static void addToMap(Map<Character, Integer> map)
    {
        map.entrySet().forEach(entry -> {
            if(finalMap.containsKey(entry.getKey()))
            {
                finalMap.put(entry.getKey(), finalMap.get(entry.getKey())+entry.getValue());
            }
            else
            {
                finalMap.put(entry.getKey(), entry.getValue());
            }
        });
    }
}


class PopulateMap implements Callable<Map<Character, Integer>>
{
    Map<Character, Integer> map = new HashMap<>();

    String string;

    public PopulateMap(String string) {
        this.string = string;
    }

    @Override
    public Map<Character, Integer> call()
    {
        System.out.println(Thread.currentThread().getName());
        populateHashMap();
        return map;
    }

    private  void populateHashMap()
    {
        for(char ch: string.toCharArray())
        {
            if(map.containsKey(ch))
            {
                map.put(ch, map.get(ch)+1);
            }
            else
            {
                map.put(ch, 1);
            }
        }
    }
}

