package dp;

import java.util.Arrays;

/**
 * @author nalin.sharma on 11/09/21
 *
 *    a  b  s  s  b  w  a
 *  a 1  1  1  2  4  4  6
 *  b    1  1  2  4  4  4
 *  s       1  2  2  2  2
 *  s          1  1  1  1
 *  b             1  1  1
 *  w                1  1
 *  a                   1
 */
public class LongestPalindromicSubSequence {
    public static void main(String[] args) {
        String s = "abssbwa";
        int dp [][] = new int[s.length()][s.length()];
        int len = 1, col;
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        while(len < s.length()) {
            for (int j = 0; j + len < s.length(); j++) {
                col = j + len;
                dp[j][col] = Math.max(dp[j+1][col], dp[j][col - 1]);
                if(s.charAt(j) == s.charAt(col)) {
                    dp[j][col] = Math.max(dp[j][col], dp[j+1][col-1] + 2);
                }
            }
            len++;
        }
       /* Arrays.asList(dp)
        Arrays.stream(dp).flatMap(a -> Arrays.stream(a))*/
        for (int i = 0; i < s.length(); i++) {
            System.out.println();
            for (int j = 0; j < s.length(); j++) {
                System.out.print(dp[i][j] +" ");
            }
        }

        char out [] = new char[dp[0][s.length() - 1]];
        int ind [] = {0};
        print(dp, s, 0, s.length() - 1, out, ind);
        System.out.println("\n "+new String(out));
    }

    private static void print(int[][] dp, String s, int i, int j, char [] out, int[] ind) {
        if(dp[i][j] == 0) {
            return;
        }
        if(dp[i][j] == dp[i][j-1]) {
            print(dp,s,i,j-1,out,ind);
        }
        else if(dp[i][j] == dp[i+1][j]) {
            print(dp,s,i+1,j,out,ind);
        }
        else {
            out[ind[0]] = out[out.length - 1 - ind[0]] = s.charAt(j);
            ind[0]++;
            print(dp,s,i+1,j-1,out,ind);
        }
    }
}
