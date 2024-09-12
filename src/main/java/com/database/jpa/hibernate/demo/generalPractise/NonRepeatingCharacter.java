package com.database.jpa.hibernate.demo.generalPractise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonRepeatingCharacter extends Thread
{
    public static void main(String[] rags)
    {
        Map<Character, Integer> map = new HashMap<>();
        String string = "hrevygubhjygecvhhbjhygvhbnjuiyghvbnjkijuhhbnmkiuhhgvmkjiuhh bmklhb mkhhvgb mkiuhgvb nkmijugv bnkjhgvb njkhgvb njjigv bnjkjgvh bnkjigv bmkgv bmkjihhbb mkluhgv";
        String str1 = string.substring(0, 50);
        String str2 = string.substring(50, 70);
        String str3 = string.substring(70, 90);
        String str4 = string.substring(90);

//        List<Thread> list = new ArrayList<>();
//        list.add(new PopulateMap(str1));
//        list.add(new PopulateMap(str2));
//        list.add(new PopulateMap(str3));
//        list.add(new PopulateMap(str4));
        Thread thread1 = new PopulateMap(str1);
        Thread thread2 = new PopulateMap(str2);
        Thread thread3 = new PopulateMap(str3);
        Thread thread4 = new PopulateMap(str4);

        long time = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

//        list.stream().forEach(thread -> thread.start());

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
//            list.stream().forEach(thread -> {
//                try {
//                    thread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() -time);

        addToMap(thread1, map);
        addToMap(thread2, map);
        addToMap(thread3, map);
        addToMap(thread4, map);
        System.out.println(map);

        System.out.println(((PopulateMap)thread1).getMap());
        System.out.println(((PopulateMap)thread2).getMap());
        System.out.println(((PopulateMap)thread3).getMap());
        System.out.println(((PopulateMap)thread4).getMap());
    }

    private static void addToMap(Thread thread, Map<Character, Integer> map)
    {

        ((PopulateMap)thread).getMap().entrySet().forEach( entry -> {
            if(map.containsKey(entry.getKey()))
            {
                map.put(entry.getKey(), map.get(entry.getKey())+entry.getValue());
            }
            else
            {
                map.put(entry.getKey(), entry.getValue());
            }
        });
    }
}


class PopulateMap extends Thread
{
    static volatile Map<Character, Integer> map = new HashMap<>();

    String string;

    public PopulateMap(String string) {
        this.string = string;
    }

    @Override
    public void run()
    {
        super.run();
        System.out.println(Thread.currentThread().getName());
        populateHashMap();
    }

    private  void populateHashMap()
    {
        if("Thread-2".equals(Thread.currentThread().getName()))
        {
            System.out.println("Inside thread");
        }
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

    public Map<Character, Integer> getMap()
    {
        return map;
    }
}
