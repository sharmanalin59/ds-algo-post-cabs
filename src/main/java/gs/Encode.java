package gs;

/**
 * @author nalin.sharma on 15/09/21
 */
public class Encode {
    public static void main(String[] args) {
        String s = "aaaaa";
        int cur, i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()) {
            cur = i;
            while(i + 1 < s.length() && s.charAt(cur) == s.charAt(i+1)) {
                i++;
            }
            i++;
            sb.append(s.charAt(cur)).append(i - cur);
            //sb.append("");
            //System.out.print(s.charAt(cur) +""+(i - cur));
        }
    }
}
