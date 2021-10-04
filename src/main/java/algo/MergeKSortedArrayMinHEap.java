package algo;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArrayMinHEap {
    public static void main(String[] args) {
        int a [] [] = {
                {2, 4, 8},
                {3},
                {9,14,19,20}
        };
        int s = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < a.length; i++) {
            s += a[i].length;
            pq.add(a[i][0]);
        }
        int ind = 0, o = 0, kInd = 0;
        int [] k = new int[a.length];
        int [] out = new int[s];
        while(ind < s-a.length) {
            if(!pq.isEmpty()) {
                int removed = pq.remove();
            }
            ind++;
        }
    }
}
