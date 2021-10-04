package hackerrank;

import java.util.*;

/**
 * @author nalin.sharma on 20/07/21
 */
public class TetrisTypeProblem {
    /*
      abaaa
      aba3
      if k = 1, remove b = a4 ans(2) minimum length
      if k = 2, remove ab = a3 ans(2)

      aabacab
      a2bcdba2
     */
    static class W {
        W(char d, int i1, int i2) {
            c = d;
            ind1 = i1;
            ind2 = i2;
        }
        char c;
        int ind1, ind2;
    }
    public static void main(String[] args) {
        int k = 3;
        String s = "aabcdbaa";
        StringBuilder ns = new StringBuilder(s.charAt(0));
    //  List<Integer> l = new ArrayList<>();
        int cnt = 0;
        if(s.charAt(0) == s.charAt(1)) {
            cnt = 1;
        }
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                cnt++;
            }
            else {
                if(cnt > 1) {
                    ns.append(cnt + 1);
                }
                ns.append(s.charAt(i));
                cnt = 0;
            }
        }
        if(cnt > 1){
            ns.append(cnt);
        }

        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < ns.length(); i++) {
            char c = ns.charAt(i);
            /*if(Character.isDigit(c)) {
                continue;
            }*/
            int ascii = (int)c;
            if(ascii >= 48 && ascii < 57) {
                continue;
            }
            if(!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }

        PriorityQueue<W> q = new PriorityQueue<>((w1, w2) -> {
            return Integer.compare(Math.abs(w1.ind1 - w1.ind2), Math.abs(w2.ind1 - w2.ind2));
        });
        map.forEach((key,val) -> {
            for(int i = 0; i < val.size(); i++) {
                for(int j = i+1; j < val.size(); j++) {
                    q.add(new W(key, val.get(i), val.get(j)));
                }
            }
        });

        Set<Integer> indexesConsumed = new HashSet<>();
        char [] narrr = ns.toString().toCharArray();
        while(!q.isEmpty()) {
            W w = q.remove();
            //check
            int low, high;
            if(k == 0) {
                break;
            }
            if(w.ind1 > w.ind2) {
                low = w.ind1;
                high = w.ind2;
            }
            else {
                low = w.ind2;
                high = w.ind1;
            }
            boolean ok = true;
            for(int i = low; i <= high; i++) {
                if(narrr[i] == '*') {
                    ok = false;
                    break;
                }
            }
            if(ok) {
                for(int i = low+1; i <= high; i++) {
                    narrr[i] = '*';
                }
                if((high == narrr.length - 1) || !Character.isDigit(high+1)) {
                    if(Character.isDigit(low+1)) {
                        k -= (high - low - 3);
                    }
                    else {
                        k -= (high - low - 2);
                    }
                }
                else if(Character.isDigit(high+1)) {
                    if(Character.isDigit(low+1)) {
                        k -= (high - low - 4);
                    }
                    else {
                        k -= (high - low - 3);
                    }
                }
            }
        }
    }
}
