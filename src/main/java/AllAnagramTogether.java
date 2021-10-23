import java.util.*;

/**
 * @author nalin.sharma on 23/10/21
 */
public class AllAnagramTogether {
    static class Entry {
        String val;
        char [] copy;
        public Entry(String val) {
            this.val = val;
            copy = val.toCharArray();
            Arrays.sort(copy);
        }
    }
    static void sol1_sorting() {
        String [] arr = {"cat", "dog", "tac", "god","doooog"};
        Entry [] entryArr = new Entry[arr.length];
        for(int i = 0; i < arr.length; i++) {
            entryArr[i] = new Entry(arr[i]);
        }
        Arrays.sort(entryArr, (e1, e2) -> new String(e1.copy).compareTo(new String(e2.copy)));
        for(int i = 0; i < arr.length; i++) {
            System.out.print(entryArr[i].val+" ");
        }
    }
    static void sol2_hashing() {
        String [] arr = {"cat", "dog", "tac", "god","doooog"};
        Map<String, List<String>> map = new HashMap<>();
        char [] carr; String str;
        for(int i = 0; i < arr.length; i++) {
            carr = arr[i].toCharArray();
            Arrays.sort(carr);
            str = new String(carr);
            if(!map.containsKey(str)) {
               map.put(str, new LinkedList<>());
            }
            map.get(str).add(arr[i]);
        }

        map.forEach((k,v) -> System.out.println(v));
    }
    public static void main(String[] args) {
        sol1_sorting();
        sol2_hashing();
    }
}
