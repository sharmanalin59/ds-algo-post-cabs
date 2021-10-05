import java.util.HashSet;
import java.util.Set;

/**
 * @author nalin.sharma on 05/10/21
 */
public class LargestSubStriing {
    public static void main(String[] args) {
        String s = "aman";
        int l = 0, r = 0, indS = -1, indE = -1;
        Set<Character> set = new HashSet<>();
        int size;
        while(r < s.length()) {
            char c = s.charAt(r);
            if(set.contains(c)) {
                //trim
                set.add(c);
                r++;
                while(!set.contains(c)) {
                    set.remove(s.charAt(l++));
                }
                set.remove(s.charAt(l++));
            }
            else {
                set.add(c);
                r++;
            }
            if((indE == -1 && indS == -1) ||
                    (r - l + 1 > indE - indS + 1)) {
                indS = l;
                indE = r;
            }
        }
        System.out.println(indS +" "+indE +" "+ s.substring(indS, indE));
    }
}
