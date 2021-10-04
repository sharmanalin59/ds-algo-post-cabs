package algo.thoughtspot;

public class MaxSumOfKPartitionMinimums {

    public static void main(String[] args) {
        int arr [] = { 5, 7, 4, 2, 8, 1, 6 }; //{3,5,8,90,10,9,2};
        int k = 3;
        int dp [] [] = new int [arr.length][k+1];

        int max = rec(arr,0,k, dp, 0);
        System.out.println(max);

    }

    private static int rec(int[] arr, int ind, int k, int[][] dp, int sum) {

        if(k == 0) {
            //return 0;

            //worked
            /*if(ind == arr.length) {
                return 0;
            }
            else if(ind < arr.length) {
                return Integer.MIN_VALUE;
            }*/
            return 1000000000;
        }
        else if(dp[ind][k] > 0) {
            return dp[ind][k];
        }
        else {
            int min = arr[ind];
            int res = min;
            for (int i = ind; i <= arr.length - k; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                }
                res = Math.max(res, min + rec(arr, i + 1, k - 1, dp, sum + min));
            }
            if(k == 1) {
                res = min;
            }
            return dp[ind][k] = res;
        }
    }
}
