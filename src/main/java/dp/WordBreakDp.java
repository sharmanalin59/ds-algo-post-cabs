package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author nalin.sharma on 11/09/21
 */
public class WordBreakDp {
    public static void main(String[] args) {
        String s = "ilikesamyousung";

        String [] words = {"i","like","samsung","sam","sung","you"};
        Set<String> set = new HashSet<>(Arrays.asList(words));
        int dp [] = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            if (dp[i] == 1 || set.contains(s.substring(0, i + 1))) {
                dp[i] = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    if(set.contains(s.substring(i + 1, j + 1))) {
                        dp[j] = 1;
                    }
                }
            }
        }
        System.out.println(dp[dp.length - 1]);
    }
}
