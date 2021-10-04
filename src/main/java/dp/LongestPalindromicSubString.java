package dp;

/**
 * @author nalin.sharma on 11/09/21
 */
public class LongestPalindromicSubString {

    public static void main(String[] args) {
        String s = "ababbbbab";
        int [] len = {1};
        int [] index = {0};
        for(int i = 1; i < s.length(); i++) {
            rec(s, i, i, len, index);
            rec(s, i, i - 1, len, index);
        }
        System.out.println(s.substring(index[0], index[0] + len[0]));
    }

    private static void rec(String s, int l, int h, int[] len, int[] index) {
        if(l == -1 || h == s.length() || s.charAt(l) != s.charAt(h)) {
            return;
        }
        if(h - l + 1 > len[0]) {
            len[0] = h - l + 1;
            index[0] = l;
        }
        rec(s, l - 1, h + 1, len, index);
    }

}
