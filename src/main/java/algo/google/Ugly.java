package algo.google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author nalin.sharma on 29/07/21
 * find ugly number numbers who have only 2,3,5 as their factors
 * 1,2,3,4,5,6,8,9,10,12...
 */
public class Ugly {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1,1);
        int n = 150, c = 0, num = 150;
        while(c < n) {
            num = map.firstKey();
            map.remove(num);
            map.put(num * 2, 1);
            map.put(num * 3, 1);
            map.put(num * 5, 1);
            c++;
        }
        System.out.println(num);
    }
}
