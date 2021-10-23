package dp;

/**
 * @author nalin.sharma on 22/10/21
 */
public class DPways {
    public static int ways(int total, int k) {
        // Write your code here
        int dp [] [] = new int [k+1][total+1];
        System.out.println("total "+total+" k "+k);
        for(int j = 1; j <= total; j++) {
            dp[0][j] = 0;
            dp[1][j] = 1;
            System.out.print(dp[1][j]+" ");
        }
        for(int i = 2; i <= k; i++) {
            System.out.println();
            for(int j = 1; j <= total; j++) {
                dp[i][j] = dp[i-1][j];
                if(j > i) {
                    dp[i][j] += dp[i][j-i];
                }
                else if(j==i) {
                    dp[i][j]++;
                }
                System.out.print(dp[i][j]+" ");
            }
        }
        return dp[k][total];
    }
    public static void main(String[] args) {
        System.out.println(ways(5,3));
    }
}
