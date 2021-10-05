import java.util.*;

/**
 * @author nalin.sharma on 05/10/21
 *
 * nalin
 */
public class ArraySum {
    public static void main(String[] args) {
        int a1 [] = {1,2,3,4,7};
        int a2 [] = {2,3,4,5,7};
        Map<Integer, List<Integer>> map = new HashMap<>();
        commonEle(map, a1, a2);
        map = trimMap(map);
        if(map.size() == 0) {
            //find 1 or find 2
        }
        int s1 = 0, s2 = 0, i1 = 0, i2 = 0, oi1, oi2;
        List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(map.entrySet());
        for(int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, List<Integer>> common = list.get(i);
            int comEle = common.getKey();
            List<Integer> comInd = common.getValue();

        }
    }

    private static Map<Integer, List<Integer>> trimMap(Map<Integer, List<Integer>> map) {
        Map<Integer, List<Integer>> nMap = new HashMap<>();
        map.forEach((k,v) -> {
            if(v.size() == 2) {
                nMap.put(k, v);
            }
        });
        return nMap;
    }

    private static void commonEle(Map<Integer, List<Integer>> map, int[] a1, int[] a2) {
        for(int i = 0 ; i < a1.length; i++) {
            int ele = a1[i];
            if(!map.containsKey(ele)) {
                map.put(ele, new ArrayList<>());
            }
            map.get(ele).add(i);
        }
        for(int i = 0 ; i < a2.length; i++) {
            int ele = a2[i];
            if(!map.containsKey(ele)) {
                map.put(ele, new ArrayList<>());
            }
            map.get(ele).add(i);
        }
    }
}
