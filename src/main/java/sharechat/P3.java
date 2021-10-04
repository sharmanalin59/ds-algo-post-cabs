package sharechat;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author nalin.sharma on 27/08/21
 */
public class P3 {
    static int solve(long N){
        long max = (2 * N) + 1, div = 1;
        int total = 0;
        while(true) {
            long rem = max%div;
            long val = max/div;
            if(rem > 0) {
                val++;
            }
            if(val - 2 <= 0) {
                break;
            }
            total += (val-2);
            div++;
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(solve(6));
    }
}
