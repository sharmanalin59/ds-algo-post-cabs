package algo.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CorrectWordBreak {
    public static void main(String[] args) {
        String s = "samsungsamsung";
        String words [] = {"","sung","samsung1","s1","am"};
        Set<String> set = new HashSet<>();
        for(String w: words) {
            set.add(w);
        }
        boolean dp [] = new boolean[s.length()];
        //int i = 0;
        for(int i = 0; i < s.length(); i++) {
            if(dp[dp.length - 1])
                break;
            if(!dp[i] && set.contains(s.substring(0, i + 1))) {
                dp[i] = true;
            }
            if(dp[i]) {
                for (int j = i + 1; j < s.length(); j++) {
                    if(!dp[j] && set.contains(s.substring(i + 1, j + 1))) {
                        dp[j] = true;
                    }
                }
            }
        }
        System.out.println(dp[dp.length - 1]);
    }
}
