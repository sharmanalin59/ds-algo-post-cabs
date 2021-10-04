package algo.google;

/**
 * @author nalin.sharma on 30/07/21
 *   413 15
 *   112 [out]
 *   113 154
 *   123 36
 *   13315
 *   12224 -> abbbd / lbbd /... etc
 *   find total
 */
public class NumberOfWays123Facebook {
    static int convert(int a, int b) {
        return a*10+b;
    }
    public static void main(String[] args) {
        int arr [] = {5,1,5};
        int dp [] = new int[arr.length];
        dp[0] = 1;
        if(convert(arr[0], arr[1]) <= 26) {
            dp[1] = 2;
        }
        else {
            dp[1] = 1;
        }
        for(int i = 2; i < arr.length; i++) {
            int num = convert(arr[i-1], arr[i]);
            dp[i] = dp[i-1];
            if(num <= 26) {
                dp[i] += dp[i-2];
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(dp[i]);
        }
    }
}
