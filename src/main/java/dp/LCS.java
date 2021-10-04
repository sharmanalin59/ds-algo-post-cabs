package dp;

/**
 * @author nalin.sharma on 11/09/21
 *
 *
 *       a b d c
 *     0 0 0 0 0
 *   a 0 1 1 1 1
 *   b 0 1 2 2 2
 *   m 0 1 2 2 2
 *   c 0 1 2 2 3
 */
public class LCS {
    public static void main(String[] args) {
        String a = "adbc";
        String b = "abmc";
        int dp [][] = new int[b.length()+1][a.length()+1];
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                /*if(a.charAt()) {

                }*/
            }
        }
    }
}
