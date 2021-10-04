package dp;

/**
 * @author nalin.sharma on 27/09/21
 *
 *
 * {2, 6, 4, 5, 7}
 *  1  1  1  1  1
 *  4  1  2  1  0
 *  4  0  1  0  0
 * Output : 5
 * The subsequences of size '3' are:
 * {2, 6, 7}, {2, 4, 5}, {2, 4, 7},
 * {2, 5, 7} and {4, 5, 7}.
 *
 */
public class CountIncreasingSubsequenceOfLengthK {
    public static void main(String[] args) {
        int arr [] = {2, 6, 4, 5, 7};
        int dp [][] = new int [arr.length][arr.length];
        int k = 4, cnt = 1;
        for(int i = 0; i < arr.length; i++) {
            dp[0][i] = 1;
        }

        int res = 0;
        while(cnt < k) {
            for (int i = 0; i < arr.length; i++) {
                res = 0;
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[i] < arr[j]){
                        res += dp[cnt-1][j];
                    }
                }
                dp[cnt][i] = res;
            }
            cnt++;
        }
        res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += dp[k-1][i];
        }
        System.out.println(res);
    }
}
