package algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCount {
    public static void main(String[] args) {
        String sen = "samsungsamsung";
        String words[] = {"samsungsam","sam","samsung","sung","sungsam"};
        Set set = new HashSet();
        Arrays.stream(words).forEach(set::add);
        System.out.println(wordBreak(sen, 0, set));
        Set<Integer> indexes = new HashSet<>();
        System.out.println(wordBreakDP(sen, 0, set, indexes));
    }

    private static boolean wordBreakDP(String sen, int ind, Set set, Set indexes) {
        if(ind == sen.length()) {
            return true;
        }
        for(int i = ind; i < sen.length(); i++) {
            boolean res;
            if (set.contains(sen.substring(ind, i + 1)) && !indexes.contains(i+1)) {
                res = wordBreak(sen, i+1, set);
                if(res) return true;
            }
        }
        //here index ind is exhausted
        indexes.add(ind);
        return false;
    }

    private static boolean wordBreak(String sen, int ind, Set set) {
        if(ind == sen.length()) {
            return true;
        }
        for(int i = ind; i < sen.length(); i++) {
            boolean res;
            if (set.contains(sen.substring(ind, i + 1))) {
                res = wordBreak(sen, i+1, set);
                if(res) return true;
            }
        }
        return false;
    }
}
