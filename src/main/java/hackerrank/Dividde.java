package hackerrank;

import java.util.*;

/**
 * @author nalin.sharma on 14/06/21
 */
public class Dividde {

    /**
     *
     * 4/2 = 2
     * 2/4 = 0.5
     * -2/4 = -0.5
     * 7/3 = 2.(3)
     * 9/7 = 1.(285714)  [1.28571428571428571...]
     * 13/7 = 1.857142   [1.85714285714285...]
     * 2/3 = 0.(6)
     * 13 ÷ 21 = 0.619047619047
     * 13 ÷ 22 = 0.5(90)  [0.590909090909...]
     *
     * abxababxabc
     *
     */
    public static String divide(int dividend, int divisor) {
        // Write your code here
        String [] out = {""};
        int rem = 0, n = Math.abs(dividend);
        List<Integer> l = new ArrayList<>();
        List<Integer> tl = new ArrayList<>();
        boolean found = false;
        rem = n%divisor;
        n /= divisor;
        out[0] += n;
        if(rem > 0) {
            out[0] += ".";
        }
        while(rem > 0) {
            rem *= 10;
            int q = rem%divisor;
            rem /= divisor;
            l.add(rem);
            rem = q;
        }

        int [] cnt = {0};
        if(found) {
            /*map.forEach((k,v) -> {
                if(!v) {
                    out[0] += k;
                }
                else {
                    if(cnt[0] == 0) {
                        out[0] += "(";
                        cnt[0]++;
                    }
                    out[0] += k;
                }
            });*/
        }
        else {
            /*map.forEach((k,v) -> {
                out[0] += k;
            });*/
        }

        if(cnt[0] == 1) {
            out[0] += ")";
        }

        if(dividend < 0) {
            return "-"+out;
        }
        return out[0];
    }
    public static void main(String[] args) {
        System.out.println(divide(3456919,9999000));
    }
}
