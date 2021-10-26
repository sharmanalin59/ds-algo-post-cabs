import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String s =   "aaaaa";
        String pat = "aaa";
        int preSuffix [] = new int[pat.length()];
        int i = 0, j= 1;

        while(j < pat.length()) {
            while(j < pat.length() && pat.charAt(i) == pat.charAt(j)) {
                preSuffix[j] = i+1;
                i++;j++;
            }
            if(i > 0) {
                i = preSuffix[i-1];
                continue;
            }
            j++;
        }
        for(int x = 0; x < preSuffix.length; x++) {
            System.out.print(preSuffix[x]+" ");
        }

        int ind = 0,x= 0;
        while(x < s.length()) {
            if(s.charAt(x) == pat.charAt(ind)) {
                ind++;
                x++;
            }
            else if(ind >0){
                ind = preSuffix[ind-1];
            }
            else {
                x++;
            }
            if(pat.length() == ind) {
                System.out.println("at "+(x-pat.length())+" "+s.substring(x-pat.length(), x));
                ind = preSuffix[ind-1];
            }
        }
    }
}
