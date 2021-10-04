package algo.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWordCount {
    public static void main(String[] args) {
        String s = "3141592653589793238462643383279";
        String words [] = {"314","49","9001","15926535897","14","9323","8462643383279","4","793"};
        Set<String> set = new HashSet<>();
        Set<Integer> noResult = new HashSet<>();
        for(String w:words){
            set.add(w);
        }
        String sol[] = {""};
        dfs(s,0,set, noResult,"", sol);
        System.out.println(sol[0]);
    }
    static void dfs(String s, int ind, Set<String> set,Set<Integer> noResult, String cur, String[] sol) {
        if(ind == s.length() && (sol[0].isEmpty() || cur.length() < sol[0].length())) {
            sol[0] = cur;
        }
        if(!noResult.contains(ind)) {
            for (int i = ind; i < s.length(); i++) {
                String sub = s.substring(ind, i + 1);
                if (set.contains(sub)) {
                    dfs(s, i + 1, set, noResult, cur + " " + sub, sol);
                }
            }
            noResult.add(ind);
        }
    }
}
