package algo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author nalin.sharma on 07/09/21
 */
public class StreamConcurrentModificaton {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        new Thread(() -> {
            try {
                map.put(4, 1);
                Thread.sleep(1000);
                map.put(5, 2);
                Thread.sleep(1000);
                map.put(6, 2);
                Thread.sleep(1000);
                map.put(7, 2);
                Thread.sleep(1000);

            }catch (InterruptedException e) {System.out.println("Excepton..");}
        }).start();
        new Thread(() -> {
            try {
                /*Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
                while(it.hasNext()) {
                    System.out.println(it.next());
                    Thread.sleep(1000);
                }*/
                Thread.sleep(2000);
                /*map.entrySet().stream().forEach(i->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                });*/
/*
                Set<Map.Entry<Integer, Integer>> s = map.entrySet().stream()
                        .filter(e -> e.getKey() > 0).collect(Collectors.toSet());
                s.stream().forEach(e -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    System.out.println(e.getKey());
                });*/
                Set<Map.Entry<Integer, Integer>> l = new HashSet<>(map.entrySet());
                for(Map.Entry<Integer, Integer> e : l) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    System.out.println(e.getKey());
                }
            }catch (InterruptedException e) {System.out.println("Excepton..");}
        }).start();
    }
}
