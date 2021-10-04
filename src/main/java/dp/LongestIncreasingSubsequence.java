package dp;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * @author nalin.sharma on 23/06/21
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr [] = {3,  4,  -1,  0,  6,  2,  3};
        int dp [][] = new int [arr.length][arr.length];
        int len = 2;
        System.out.println("array is ");
        for(int i = 0 ; i < arr.length; i++) {
            dp[i][i] = 1;
            System.out.print(arr[i]+" ");
        }
        while(len <= arr.length) {
            for(int i = 0 ; i < arr.length - len + 1; i++) {
                int max = 0;
                //curr i, i+len-1
                dp[i][i+len-1] = Math.max(dp[i+1][i+len-1], dp[i][i+len-2]);

                if(arr[i+len-2] < arr[i+len-1] && dp[i][i+len-2] >= dp[i+1][i+len-1]) {
                    dp[i][i + len - 1] = dp[i][i + len - 2] + 1;
                }
            }
            len++;
        }
        for(int i = 0 ; i < arr.length; i++) {
            System.out.println();
            for(int j = 0 ; j < arr.length; j++) {
                System.out.print(dp[i][j]+" ");
            }
        }
        System.out.println("Numbers are : ");
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int i = arr.length - 1;
        while(i > 0) {
            if(dp[0][i-1] < dp[0][i]) {
                set.add(arr[i]);
                set.add(arr[i-1]);
            }
            i--;
        }
        set.forEach(System.out::print);
    }
}
