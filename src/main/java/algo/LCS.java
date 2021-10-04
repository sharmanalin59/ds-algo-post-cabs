package algo;

public class LCS {
    public static void main(String[] args) {
/**

         a  b  a  c  a
      0  0  0  0  0  0
   d  0  0  0  0  0  0
   a  0  1  1  1  1  1
   e  0  1  1  1  1  1
   c  0  1  1  1  2  2
   a  0  1  1  1  2  3
   f  0  1  1  1  2  3

  */

        String a = "abaca";
        String b = "daecaf";
        int dp [] [] = new int [b.length() + 1][a.length() + 1];
        for(int i = 1; i <= b.length(); i++) {
            for(int j = 1; j <= a.length(); j++) {
                if(b.charAt(i-1) == a.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int i = b.length(), j = a.length();
        while(i > 0 && j > 0) {
            if(dp[i][j] == dp[i-1][j-1] + 1) {
                System.out.println(a.charAt(j-1));
                i--;j--;
            }
            else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            }
            else{
                j--;
            }
        }

    }
}
