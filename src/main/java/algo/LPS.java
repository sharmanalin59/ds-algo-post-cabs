package algo;

/**
 * @author nalin.sharma on 31/08/21
 * longest palindromic subs
 */
public class LPS {
    public static void main(String[] args) {
        String str = "asarbbraa";
        int dp [][] = new int [str.length()][str.length()];
        int len = 1;
        for(int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }
        while(len < str.length()) {
            for (int i = len; i < str.length(); i++) {
                dp[i - len][i] = Math.max(dp[i - len + 1][i], dp[i - len][i - 1]);
                if(str.charAt(i) == str.charAt(i - len)) {
                    dp[i - len][i] = Math.max(dp[i - len][i], dp[i - len + 1][i - 1] + 2);
                }
            }
            len++;
        }
        for(int i = 0; i < str.length(); i++) {
            System.out.println();
            for(int j = 0; j < str.length(); j++) {
                System.out.print(dp[i][j] + " ");
            }
        }

        //print one of them
        char arr [] = new char[dp[0][str.length() - 1]];
        printLPS(str, dp, 0 , str.length() - 1, arr, 0);
        System.out.println("\n"+new String(arr));
    }

    private static void printLPS(String str, int[][] dp, int i, int j, char arr[], int ind) {
        if(dp[i][j] == 0) {
            return;
        }
        if(dp[i][j] == dp[i+1][j]) {
            printLPS(str, dp, i + 1, j, arr, ind);
        }
        else if (dp[i][j] == dp[i][j-1]) {
            printLPS(str, dp, i, j - 1, arr, ind);
        }
        else if(i+1 < str.length() && j-1 >= 0 && dp[i][j] == dp[i+1][j-1] + 2) {
            arr[ind] = arr[arr.length - 1 - ind] = str.charAt(i);
            printLPS(str, dp, i + 1, j - 1, arr, ind + 1);
        }
    }
}
