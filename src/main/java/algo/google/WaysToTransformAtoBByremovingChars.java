package algo.google;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/ways-transforming-one-string-removing-0-characters/
 */
public class WaysToTransformAtoBByremovingChars {
    static class Wrapper {
        int k,v;
        Wrapper(int k1, int v1) {
            k = k1;
            v = v1;
        }
    }
    public static void main(String[] args) {
        String a = "aada", b = "aaa";
        List<Wrapper> list = new ArrayList<>();

        int ai = 0, ac = 0, bc = 0, bi = 0;
        int ways [] = {1};

        while (true){
            ac = 1; bc = 1;
            if(ai == a.length() || bi == b.length()) {
                break;
            }
            if(a.charAt(ai) == b.charAt(bi)) {
                while(ai<a.length() - 1 && a.charAt(ai) == a.charAt(ai+1)) {
                    ac++;
                    ai++;
                }
                while(bi<b.length() - 1 && b.charAt(bi) == b.charAt(bi+1) && bc<ac) {
                    bc++;
                    bi++;
                }
                ai++;bi++;
                list.add(new Wrapper(ac,bc));
            }
            else{
                ai++;
                list.add(new Wrapper(1,0));
            }
        }

        if(bi == b.length()){
            list.forEach((val) -> {
                int k = val.k;
                int v = val.v;
                if(k > 1 && v > 0)
                    ways[0] *= fact(k) / (fact(v) * fact(k-v));
            });
            System.out.println(ways[0]);
        }
        else{
            System.out.println(0);
        }

    }

    static int fact(int i) {
        if(i == 0) {
            return 1;
        }
        return fact(i - 1) * i;
    }
}
