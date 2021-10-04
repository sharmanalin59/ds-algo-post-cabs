import java.util.HashMap;
import java.util.Map;

/**
 * @author nalin.sharma on 17/09/21
 */
public class Anagram {
    public static void main(String[] args) {
        String a = "a ab c";
        String b = "aba  c";
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        if(a.length() != b.length()) {
            System.out.println("not anagram");
            return;
        }
        char cA, cB;
        for(int i =0; i <a.length(); i++) {
            cA = a.charAt(i);
            if(!mapA.containsKey(cA)) {
                mapA.put(cA, 1);
            }
            else {
                mapA.put(cA, mapA.get(cA) + 1);
            }

            cB = b.charAt(i);
            if(!mapB.containsKey(cB)) {
                mapB.put(cB, 1);
            }
            else {
                mapB.put(cB, mapB.get(cA) + 1);
            }
        }
        boolean ana[] = {true};
        mapA.forEach((k,v)-> {
            if(!mapB.containsKey(k) || mapB.get(k) != v) {
                ana[0] = false;
                return;
            }
        });
        System.out.println(ana[0]);
    }
}
