package algo.google;

/**
 * @author nalin.sharma on 29/07/21
 */
public class MaximizeSumOfMinimumsFromKPartition {
    public static void main(String[] args) {
        int arr [] = {1,2,3,7,9,2,0,9};
        int k = 5;
        int out [] = {Integer.MIN_VALUE};
        rec(arr, 0, out, k, 0);
        System.out.println(out[0]);

        System.out.println("with dp");
        int [][] dp = new int[arr.length][k+1];
        recDp(arr, 0, out, k, dp);
        System.out.println(dp[0][k]);
    }

    private static void recDp(int[] arr, int i, int[] out, int k, int[][] dp) {
        if(k == 0) {
            return;
        }
        if(dp[i][k] != 0) {
            return;
        }
        int min = arr[i];
        for(int j = i; j < arr.length - (k-1); j++) {
            min = Math.min(min, arr[j]);
            recDp(arr,j + 1, out,k - 1, dp);
            if(k == 1)
            dp[i][k] = min;
            else
                dp[i][k] = Math.max(dp[i][k], dp[j+1][k-1] + min);
        }
    }

    private static void rec(int[] arr, int i, int[] out, int k, int sum) {
        if(k == 0) {
            if(i == arr.length && out[0] < sum) {
                out[0] = sum;
            }
            return;
        }
        int min = arr[i];
        for(int j = i; j < arr.length - (k-1); j++) {
            min = Math.min(min, arr[j]);
            rec(arr, j + 1, out, k - 1, min + sum);
        }
    }
}
