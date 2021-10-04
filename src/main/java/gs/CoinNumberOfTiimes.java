package gs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author nalin.sharma on 15/09/21
 *
 *
 *     0  1  2  3  4  5  6  7  8  9  10
 *  2  0  0  1  0  0  0  0  0  0  0  0
 *  3  0  0  1  1  0  1  0  0  0  0  0
 *  4  0  0  1  1  1  1  1  1  0  1  0
 *  5  0  0  1  1  1  2  1  2  1  2  1
 *  6  0  0  1  1  1  2  2  2  2  3  2
 */
public class CoinNumberOfTiimes {

    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6};
        int num = 10;
        int dp [][] = new int [arr.length][num+1];
        for(int j = 0; j < dp[0].length; j++) {
            if(j == arr[0])
            dp[0][j] = 1;
        }
        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if(j == arr[i-1]) {
                    dp[i][j]++;
                }
                else if(j > arr[i-1]) {
                    dp[i][j] += dp[i-1][j-arr[i-1]];
                }

            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println();
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
        }
    }
}
