import java.util.*;

/**
 * @author nalin.sharma on 19/09/21
 */
public class SyfeP1 {
    static class Wrapper {
        Wrapper(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
        int val, cnt;
    }
    static public int minSetSize(int[] arr) {


        List<Integer> list = new ArrayList<>();
        Collections.sort(list, Collections.reverseOrder());
        PriorityQueue<Wrapper> q = new PriorityQueue<>((w1, w2) -> Integer.compare(w2.cnt, w1.cnt));
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            }
            else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        map.forEach((k,v) -> q.add(new Wrapper(k,v)));

        int cnt = 0, size = 0;
        while(!q.isEmpty()) {
            Wrapper w = q.remove();
            System.out.println(w.val+" "+w.cnt);
            cnt += w.cnt;
            size++;
            if(cnt >= arr.length/2) {
                break;
            }
        }

        return size;
    }

    public static void main(String[] args) {
        int arr [] = {3,3,3,3,5,5,5,2,2,7};
        System.out.println(minSetSize(arr));
    }
}
