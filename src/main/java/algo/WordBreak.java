package algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "samsungbeatles";
        String [] words = {"sam","sung","samsung","beatles"};
        Set<String> set = new HashSet<>();
        Set<Integer> index = new HashSet();
        for (String w:words) {
            set.add(w);
        }
        System.out.println(rec(0,s,set,index));
    }

    private static boolean rec(int ind, String s, Set<String> set, Set<Integer> index) {
        if(index.contains(ind)) {
            return false;
        }
        if(s.length() == ind) {
            return true;
        }
        for(int i = ind; i < s.length(); i++) {
            if(set.contains(s.substring(ind, i+1))) {
                return rec(i+1,s,set,index);
            }
        }
        index.add(ind);
        return false;
    }
}
