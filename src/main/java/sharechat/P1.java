package sharechat;

/**
 * @author nalin.sharma on 27/08/21
 */
public class P1 {
    /*
      a b a b d
        go at each index and find left and right mirror recursively


     */
    public static void main(String[] args) {
        String s = "abaabad";
        int [] maxLen = {-1};
        int [] ind = {-1};
        for(int i = 0; i < s.length() ; i++) {
            palin(s, i, i, maxLen, ind); //odd length
            if(i > 0) {
                palin(s, i - 1, i, maxLen, ind); // even length
            }
        }
        if(ind[0] != -1) {
            System.out.println(s.substring(ind[0], ind[0] + maxLen[0]));
        }
        else {
            System.out.println("no palindromic substring exists");
        }
    }

    private static void palin(String s, int l, int r, int[] maxLen, int[] outInd) {
        if(l == -1 || r == s.length()) {
            return;
        }
        if(s.charAt(l) == s.charAt(r)) {
            int len = (r - l) + 1; // 1 2 [3] 4 5 = (5-1) + 1
            if(len > maxLen[0]) {
                maxLen[0] = len;
                outInd[0] = l;
            }
            palin(s,l - 1, r + 1, maxLen, outInd);
        }
    }
}
