package algo.google;

import java.util.*;
import java.util.Set;

/**
 * @author nalin.sharma on 24/07/21
 *
 * [1,2,3,5,4]
 * sum = 6 [1,5] = 3
 *
 *
 *      1  2  3  4  5  6
 *  0   0  0  0  0  0  0
 *  1   1  0  0  0  0  0
 *  3   1  0  1  1  0  0
 *  2   1  1  2  1  1  1
 *  5   1  1  2  1  2  2
 *  4   1  1  2  1  3  3
 *  6   1  1  2  1  3  4
 *
 *         1  2  3  4  5  6  7  8  9  10  11  12
 *     0   0  0  0  0  0  0  0  0  0  0   0   0
 *     1   1  0  0  0  0  0  0  0  0  0   0   0
 *     3   1  0  1  1  0  0  0  0  0  0   0   0
 *     2   1  1  2  1  1  1  0  0  0  0   0   0
 *     5   1  1  2  1  2  2  1  2  1  1   1   0
 *     4   1  1  2  1  3  3  3  3  3  3   2   2
 *     6   1  1  2  1  3  4
 *
 *        0  1  2  3
 *     0  0  0  0  0
 *     1  0  1  0  0
 *     3  0  1  0  1
 *     2  0  1  1  2
 *
 */
public class KnapsackFindAllCombinations {
    public static void main(String[] args) {
        int [] arr = {1,3,2,5,4,6};
        int sum = 5;

        int R = arr.length + 1, C = sum + 1;
        int dp [] [] = new int [R][C];
        for(int i = 1; i < R; i++) {
            for(int j = 1; j < C; j++) {
                if(arr[i-1] == j) {
                    dp[i][j] = dp[i-1][j] + 1;
                }
                else if(arr[i-1] < j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        //System.out.println(dp);
        List<Set<Integer>> sol = new ArrayList<>();
        int i = R-1,j = C-1;

        rec(new HashSet<>(), i, j, dp, arr, sol);
        System.out.println(sol);
    }

    private static void rec(Set<Integer> set, int i, int j, int[][] dp,
                            int [] arr, List<Set<Integer>> sol) {
        while(i > 0) {
            if(dp[i][j] == dp[i-1][j]) {
                i--;
                continue;
            }
            Set<Integer> nset = new HashSet<>(set);
            nset.add(arr[i-1]);
            if(j-arr[i-1] == 0) {
                sol.add(nset);
            }
            else {
                rec(nset, i-1, j-arr[i-1],dp, arr, sol);
            }
            i--;
        }
    }
}
