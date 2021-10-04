/**
 * @author nalin.sharma on 02/09/21
 */
public class EncodeNumbers {
    static void encode() {
        String s = "123";
        int lCnt = 1, rCnt = 1, i = 2;
        String tmp = ""+ s.charAt(0)+ s.charAt(1);
        if(Integer.parseInt(tmp) < 27) {
            rCnt = 2;
        }
        int num, t;
        while (i < s.length()) {
            tmp = ""+s.charAt(i);
            tmp = s.charAt(i-1) + tmp;
            num = Integer.parseInt(tmp);
            t = rCnt;
            if(num < 27) {
                t = lCnt + rCnt;
            }
            lCnt = rCnt;
            rCnt = t;
            i++;
        }
        System.out.println(lCnt+" "+rCnt);
    }
    public static void main(String[] args) {
        encode();
        cominations();
        permutations();
    }

    private static void permutations() {
        String s = "abc";
    }

    private static void cominations() {
        String s = "abc";
    }
}
