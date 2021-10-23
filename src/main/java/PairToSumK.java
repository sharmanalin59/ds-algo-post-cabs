import java.util.HashMap;
import java.util.Map;

/**
 * @author nalin.sharma on 06/10/21
 *
 *
 *  A    B
 *  cost 100 ~120
 */
public class PairToSumK {
    public static void main(String[] args) {
        int ar [] = {3, 4, 9, 7, 10, 12};
        int k = 13;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < ar.length; i++) {
            if(!map.containsKey(ar[i])) {
                map.put(ar[i], 1);
            }
            else {
                map.put(ar[i], map.get(ar[i]) + 1);
            }
        }
        for(int i = 0; i < ar.length; i++) {
            if(ar[i] <= k) {
                if (k - ar[i] == ar[i] && map.containsKey(ar[i]) && map.get(ar[i]) >= 2) {
                    System.out.println(ar[i] + " " + ar[i]);
                    break;
                }
                if (map.containsKey(k - ar[i])) {
                    System.out.println(ar[i] + " " + (k - ar[i]));
                    break;
                }
            }
        }
    }
}
