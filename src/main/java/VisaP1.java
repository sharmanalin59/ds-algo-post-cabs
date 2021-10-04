import java.util.ArrayList;
import java.util.*;

/**
 * @author nalin.sharma on 17/09/21
 */
public class VisaP1 {
    public static char maximumOccurringCharacter(String text) {
        // Write your code here
        int max[] = {1};
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char c;
        int tmp;
        char out [] = {text.charAt(0)};
        for(int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 1);
            }
            else {
                tmp = map.get(c) + 1;
                map.put(c, tmp);
                if(tmp > max[0]) {
                    max[0] = tmp;
                }
            }
        }

        Optional<Character> charFound = map.entrySet().stream().filter(e -> e.getValue() == max[0]).map(Map.Entry::getKey).findFirst();

        if(charFound.isPresent()) {
            return charFound.get();
        }
        return (0);
    }

    public static void main(String[] args) {
        System.out.println(maximumOccurringCharacter("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }
}
