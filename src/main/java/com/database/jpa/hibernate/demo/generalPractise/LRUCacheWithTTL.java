package com.database.jpa.hibernate.demo.generalPractise;

//import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LRUCacheWithTTL {
    
    
    /**
     * There are a total of n jobs you have to pick, name from 0 to n-1. Some jobs may have dependent jobs, for example to pick job 0 you have to first finish job 1,  Given the total number of jobs and a list of prerequisite jobs, return the ordering of jobs you should pick to finish all jobs. There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all jobs, return an empty array.
     * Input: 4,
     * 1 -> 0,
     * 2 -> 0
     * 3 -> 1
     * 3 -> 2
     * Output: 0, 1, 2, 3 or 0, 2, 1, 3
     * @param args
     *
     * 0->1->2->3->4
     * 0->4->2
     *
     * que-4, 3, 3
     * set-4, 3,
     */

    public static Queue<Pair<Long, UserDetails>> queue = new LinkedList();
    public static HashMap<Integer, Pair<Long, UserDetails>> hashMap = new LinkedHashMap<>(10, 0.75f, true);

    public static void main(String[] args) throws InterruptedException{
        LRUCache cache = new LRUCache();
        cache.put(new UserDetails(20));
        cache.put(new UserDetails(10));
        cache.put(new UserDetails(15));
        cache.put(new UserDetails(27));
        System.out.println(cache.get(20).userId);
//        Thread.sleep(20000);
        System.out.println(cache.get(20));
//        cache.remove(15);
        char[] ch = new char[2];
        System.out.println( (ch[0] == '\u0000'));
    }


}

class UserDetails{
    public int userId;

    public UserDetails(int id){
        this.userId = id;
    }
}
class LRUCache {

    public static Queue<Pair<Long, UserDetails>> queue = new LinkedList();
    public static HashMap<Integer, Pair<Long, UserDetails>> hashMap = new LinkedHashMap<>(10, 0.75f, true);

    public LRUCache() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        Runnable r = () -> {
            Iterator<Pair<Long, UserDetails>> iterator = queue.iterator();
            while (iterator.hasNext()){
                Pair<Long, UserDetails> pair = iterator.next();
                if (pair.getKey() <= System.currentTimeMillis()) {
                    hashMap.remove(pair.getValue().userId);
                    iterator.remove();
                }
            }
        };
        executorService.scheduleAtFixedRate(r, 0, 6, TimeUnit.SECONDS);

    }

    public UserDetails get(int userId) {
        if(hashMap.get(userId) != null)
            return hashMap.get(userId).getValue();
        return null;
    }

    public void put(UserDetails userDetails) {
        Pair<Long, UserDetails> pair = new Pair<>(System.currentTimeMillis() + 10000, userDetails);
        hashMap.put(userDetails.userId, pair);
        queue.add(pair);
    }

    public void remove(int userId) {
        Pair<Long, UserDetails> pair = hashMap.get(userId);
        if (pair != null) {
            queue.remove(pair);
            hashMap.remove(pair.getValue().userId);
        }
    }

}
