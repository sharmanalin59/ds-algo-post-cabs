package hackerrank;

import java.util.*;

/**
 * @author nalin.sharma on 09/06/21
 */


public class GlobalLogic {


    static class Wrapper {
        public Wrapper(int m, int n, int f){
            r = m;
            c = n;
            d = f;
        }
        int r,c,d;
    }
    public static void main(String[] args) {
        /*String s = "Everyday is a wonderful day";
        String txt = "Daya";
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> txtMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = Character.toUpperCase(s.charAt(i));
            if(!map.containsKey(c)) {
                map.put(c,1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
        }
        for(int i = 0; i < txt.length(); i++)
        {
            char c = Character.toUpperCase(txt.charAt(i));
            if(!txtMap.containsKey(c)) {
                txtMap.put(c,1);
            }
            else {
                txtMap.put(c, txtMap.get(c) + 1);
            }
        }

        int[] max = {Integer.MAX_VALUE};
        int cnt[] = {0};
        map.forEach((k,v) ->  {
            int rem;
            if(txtMap.containsKey(k)) {
                rem = v/txtMap.get(k);
                cnt[0]++;
                if(rem == 0) {
                    max[0] = 0;
                    return;
                }
                else if (rem < max[0]){
                    max[0] = rem;
                }
            }
        });

        if(cnt[0] == txtMap.size()) {
            System.out.println(max[0]);
        }
        else {
            System.out.println(-1);
        }*/

        System.out.println(";;;;;;;;;");
        List<Integer> scores = new ArrayList<>();

        scores.add(20);
        scores.add(40);
        scores.add(60);
        scores.add(80);
        scores.add(100);
        LinkedList<Integer> ranks = new LinkedList<>();

        int k = 4;
        PriorityQueue<Integer> p = new PriorityQueue<>((e1,e2) -> Integer.compare(e2,e1));
        scores.forEach(e -> p.add(e));
        int i = 1, old = p.remove(), cnt = 1;
        while(!p.isEmpty()) {
            int nele = p.remove();
            if(nele != old) {
                i++;
            }
            cnt++;
            if(cnt > k) {
                break;
            }
        }
        if(p.isEmpty()) {
            System.out.println(scores.size());
        }
        System.out.println(cnt-1);
    }

}
