package algo;

public class KMP {
    public static void main(String[] args) {
        String text = "aaaabaaaaa";
        String pattern = "aaaaa";
        int [] preSuffix = new int[pattern.length()];
        int j = 0, i = 1;
        while(i<pattern.length()) {
            if(pattern.charAt(i) != pattern.charAt(j)) {
                if(j == 0) {
                    i++;
                }
                else {
                    j = preSuffix[j-1];
                }
            }
            else if(pattern.charAt(i) == pattern.charAt(j)) {
                preSuffix[i] = j + 1;
                i++;
                j++;
            }
        }

        //prefix
        for(i = 0; i < preSuffix.length; i++) {
            System.out.print(" " + preSuffix[i]);
        }

        //KMP
        j = 0; i = 0;
        while(i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if(j == pattern.length()) {
                    System.out.println("\n ending at: "+(i-1) +" "+ pattern.length());
                    j = 0;
                }
            }
            else if(text.charAt(i) != pattern.charAt(j)) {
                //backtrack in pattern next smaller than current largest prefix which is also as suffix until j becomes 0
                if(j > 0) {
                    j = preSuffix[j - 1];
                }
                else {
                    //j is 0, and was not matched(charAt(0) != charAt(i)) so go ahead with i
                    i++;
                }
            }
        }
    }
}
