import java.util.*;

/**
 * @author nalin.sharma on 23/10/21
 */
public class SnakeLadder {
    static class Entry {
        int val, cnt;

        public Entry(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) {
        int arr [] = new int[101];
        Map<Integer, Integer> snakeLadders = new HashMap<>();
        snakeLadders.put(8,95);
        int i = 1;
        Queue<Entry> q = new LinkedList<>();
        q.add(new Entry(1,0));
        Set<Integer> visited = new HashSet<>();
        while(true) {
            Entry rem = q.remove();
            if(rem.val == 100) {
                System.out.println(rem.cnt);
                break;
            }
            visited.add(rem.val);
            for (int j = 1; j < 7; j++) {
                if (!visited.contains(rem.val + j) && rem.val + j <= 100) {
                    if(snakeLadders.containsKey(rem.val + j)
                            && (rem.val + j) < snakeLadders.get(rem.val + j)) {
                        q.add(new Entry(snakeLadders.get(rem.val + j), rem.cnt + 1));
                    }
                    else {
                        q.add(new Entry(rem.val + j, rem.cnt + 1));
                    }
                }
            }
        }
    }
}
