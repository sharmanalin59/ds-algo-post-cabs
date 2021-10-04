import java.util.HashMap;
import java.util.Map;

public class MinLengthSubstringContainingAlphabetsOfWord {
    public static void main(String[] args) {
        String word = "tist";
        String sen = "this is a test string";
        Map<Character, Integer> masterWordMap = new HashMap<>();
        Map<Character, Integer> wordMap = new HashMap<>();
        int lInd = -1, rInd = -1, finallInd = -1, finalrInd = -1, len = 0;

        for(int i=0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(masterWordMap.containsKey(currentChar))
            masterWordMap.put(currentChar, masterWordMap.get(currentChar) + 1);
            else
                masterWordMap.put(currentChar, 1);
        }

        for(int i=0; i < sen.length(); i++) {
            rInd = i;
            char currentChar = sen.charAt(i);
            if(masterWordMap.containsKey(currentChar)) {
                if(lInd == -1) {
                    lInd = i;
                }
                if(!wordMap.containsKey(currentChar)) {
                    wordMap.put(currentChar, 1);
                    len++;
                }
                else if(wordMap.get(currentChar) < masterWordMap.get(currentChar)) {
                    wordMap.put(currentChar, wordMap.get(currentChar) + 1);
                    len++;
                }
                else {
                    wordMap.put(currentChar, wordMap.get(currentChar) + 1);
                }
            }
            if(len == word.length()) {
                while(lInd<rInd) {
                    if(finallInd == -1 && finalrInd == -1) {
                        finallInd = lInd;
                        finalrInd = rInd;
                    }
                    else if (finalrInd - finallInd > rInd - lInd) {
                        finalrInd = rInd;
                        finallInd = lInd;
                    }

                    if(masterWordMap.containsKey(sen.charAt(lInd))) {
                        if(wordMap.get(sen.charAt(lInd)).equals(masterWordMap.get(sen.charAt(lInd)))) {
                            len--;
                            wordMap.put(sen.charAt(lInd), wordMap.get(sen.charAt(lInd)) - 1);
                            lInd++;
                            break;
                        }
                        wordMap.put(sen.charAt(lInd), wordMap.get(sen.charAt(lInd)) - 1);
                    }
                    lInd++;
                }
            }
        }
        if(finallInd != -1 && finalrInd != -1)
        System.out.println(sen.substring(finallInd, finalrInd + 1));
    }
}
