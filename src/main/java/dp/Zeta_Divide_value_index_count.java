package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author nalin.sharma on 12/09/21
 */
public class Zeta_Divide_value_index_count {
    public static void main(String[] args) {
        int n = 7;
        Set<Integer> set = new HashSet<>();
        int a [] = new int[n];
        int out [] = {0};
        rec(a, 0 , n, out, set);
        System.out.println(out[0]);
    }

    private static void rec(int[] a, int ind, int n, int[] out, Set<Integer> set) {
        if(ind == a.length) {
            out[0]++;
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(!set.contains(i) && (i%(ind+1)==0 || (ind+1)%i==0)) {
                a[ind] = i;
                set.add(i);
                rec(a, ind + 1, n, out, set);
                set.remove(i);
            }
        }
    }
}
