package algo.google;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
 */
public class LongestWindowWIthexactKcharacters {
    public static void main(String[] args) {
        String s = "aaabbb";
        Map<Character,Integer> map = new HashMap<>();
        int lInd = 0, rInd = 0,lFinalInd = -1, rFInalInd = -1, k = 2;

        for (; rInd<s.length(); rInd++) {
            char currentChar = s.charAt(rInd);
            if(!map.containsKey(currentChar)) {
                map.put(currentChar, 0);
            }
            map.put(currentChar, map.get(currentChar) + 1);


            if(map.size() == k) {
                if((lFinalInd == -1 && rFInalInd == -1) || (rFInalInd - lFinalInd < rInd - lInd)) {
                    lFinalInd = lInd;
                    rFInalInd = rInd;
                }
            }
            if(map.size() == k+1) {
                //go until count becomes 1 less than the k
                while(lInd < rInd) {
                    if(map.containsKey(s.charAt(lInd))) {
                        if(map.get(s.charAt(lInd)) == 1) {
                            map.remove(s.charAt(lInd));
                            lInd++;
                            break;
                        }
                        map.put(s.charAt(lInd), map.get(s.charAt(lInd)) - 1);
                    }
                    lInd++;
                }
            }
        }
        if(lFinalInd != -1 && rFInalInd != -1)
        System.out.println(s.substring(lFinalInd,rFInalInd+1));

    }
}
