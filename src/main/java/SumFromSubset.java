import java.util.HashSet;
import java.util.Set;

/**
 * @author nalin.sharma on 01/09/21
 */
public class SumFromSubset {
    public static void main(String[] args) {
        int n = 10;
        int arr [] = {2,3,5,6,8,10};
        int dp [][] = new int [arr.length+1][n+1];
        for (int i = 1; i <= arr.length; i++) {
            System.out.println();
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                if(arr[i-1] == j) {
                    dp[i][j]++;
                }
                else if(j > arr[i-1] && dp[i-1][j - arr[i-1]] > 0) {
                    dp[i][j] += dp[i-1][j - arr[i-1]];
                }
                System.out.print(dp[i][j]+" ");
            }
        }
        Set<Set<Integer>> set = new HashSet<>();
        sol(arr, dp, dp.length - 1, dp[0].length - 1, set, new HashSet<>());
        System.out.println(set);
    }

    private static void sol(int[] arr, int[][] dp, int i, int j, Set<Set<Integer>> out, Set<Integer> set) {
        if(j == 0) {
            out.add(set);
            return;
        }
        for(int m = i; m > 0 ; m--) {
            if(dp[m][j] == 0){
                return;
            }
            if(dp[m][j] > dp[m-1][j]) {
                Set<Integer> nSet = new HashSet<>(set);
                nSet.add(arr[m - 1]);
                sol(arr, dp, m - 1, j - arr[m - 1], out, nSet);
            }
        }
    }
}
