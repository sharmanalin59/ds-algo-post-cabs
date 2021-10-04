package algo;

import java.util.PriorityQueue;
import java.util.Queue;

public class SortAlmostSortedArrKDistanceAway {
    public static void main(String[] args) {
        int a [] = {2,1,5,4,3,7};
        int k = 2;
        Queue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < k + 1; i++) {
            q.add(a[i]);
        }
        for(int i = k + 1; i < a.length; i++) {
            int removed = q.remove();
            q.add(a[i]);
            System.out.println(removed);
        }
        while(!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
