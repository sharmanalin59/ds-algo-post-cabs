package algo.google;

import java.util.*;

/**
 * @author nalin.sharma on 22/07/21
 *
 * code to print duplicate characters in given string:
 * developer
 */
public class P1 {
    public static void main(String[] args) {

        //duplicate();
        exception();
    }

    private static void duplicate() {
        String s = "abacab";
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for(int j = i+1; j < s.length(); j++) {
                if(c == s.charAt(j)) {
                    System.out.println(c);
                    break;
                }
            }
        }
        System.out.println("using collection");
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
        }
        map.forEach((k,v) -> {
            if(v > 1) {
                System.out.println(k+" "+v);
            }
        });
    }

    private static void exception() {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        Iterator<Integer> it = l.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
            l.remove(new Integer(1));
        }
    }
}
