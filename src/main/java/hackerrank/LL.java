package hackerrank;

import java.util.Map;

/**
 * @author nalin.sharma on 11/06/21
 */
public class LL {

    public static int ways(int total, int k) {
        // Write your code here
        int [][] dp = new int[k+1][total+1];
        for(int i = 1; i <= total; i++) {
            dp[1][i] = 1;
        }
        for(int i = 1; i <= k; i++) {
            dp[i][0] = 1;
        }
        for(int i = 2; i <= k; i++) {
            for(int j = 1; j <= total; j++) {
                int cnt = dp[i-1][j];
                if(j >= i) {
                    cnt += dp[i][j-i];
                }
                dp[i][j] = cnt;
            }
        }
        return dp[k][total];
    }
    public static void main(String[] args) {
        System.out.println(ways(5,3));
    }
}
