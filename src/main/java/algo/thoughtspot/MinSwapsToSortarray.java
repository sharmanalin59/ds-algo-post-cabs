package algo.thoughtspot;

import java.util.ArrayList;
import java.util.List;

public class MinSwapsToSortarray {

    static class Pair {
        Pair(int i, int v) {
            ind = i;
            val = v;
        }
        int ind, val;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1};
        List<Pair> l = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            l.add(new Pair(i, arr[i]));
        }
        l.sort((p1,p2) -> {
            return Integer.compare(p1.val, p2.val);
        });

        //graph
        int cnt = 0, total = 0, ind = 0;
        boolean visited [] = new boolean[arr.length];
        for(int i = 0; i < l.size(); i++) {
            cnt = 0;
            Pair p = l.get(i);
            int in = p.ind;
            while(!visited[in]) {
                visited[in] = true;
                in = l.get(in).ind;
                cnt++;
            }
            if(cnt > 0)
            total += (cnt - 1);
        }
        System.out.println(total);
    }
}
