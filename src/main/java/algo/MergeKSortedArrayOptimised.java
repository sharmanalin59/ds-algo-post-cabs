package algo;

import java.util.PriorityQueue;

/**
 * @author nalin.sharma on 01/09/21
 */
public class MergeKSortedArrayOptimised {
    public static void main(String[] args) {
        int a [] [] = {
                {1, 2, 4, 8, 12},
                {3, 7, 9, 10, 14},
                {3, 5, 6, 11, 13}
        };
        sortMerge(a.clone());

        sortMinHeap(a.clone());
    }

    static class Node {
        Node(int aind, int i) {
            arrInd = aind;
            ind = i;
        }
        int arrInd, ind;
    }
    private static void sortMinHeap(int[][] a) {
        System.out.println("\nsort min heap");
        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(a[n1.arrInd][n1.ind], a[n2.arrInd][n2.ind]);
        });
        for(int i = 0; i < a.length; i++) {
            q.add(new Node(i, 0));
        }
        while(!q.isEmpty()) {
            Node node = q.remove();
            System.out.print(a[node.arrInd][node.ind]+" ");
            if(node.ind + 1 < a[node.arrInd].length) {
                q.add(new Node(node.arrInd, node.ind + 1));
            }
        }
    }

    private static void sortMerge(int[][] a) {
        System.out.println("sort merge");
        int k = a.length, size = a[0].length;
        int [] out = new int[k*size];
        int oInd = 0;
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < size; j++) {
                out[oInd++] = a[i][j];
            }
        }
        int chunkSize = size;
        divide(out, 0,k-1, chunkSize);
        //print
        for(int i = 0; i < out.length; i++) {
            System.out.print(out[i] + " ");
        }
    }

    private static void divide(int[] a, int l, int h, int chunkSize) {
        if(h <= l) {
            return;
        }
        int mid = (l+h) /2 ;
        divide(a, l, mid, chunkSize);
        divide(a, mid + 1, h, chunkSize);
        merge(a, l, mid + 1 ,h, chunkSize);
    }

    private static void merge(int[] a, int l, int mid, int h, int chunkSize) {
        int p = (l * chunkSize), q = (mid * chunkSize), down, up = (h+1) * chunkSize;
        down = q - 1;
        up--;
        int [] out = new int [chunkSize * (h - l + 1)];
        int o = 0;
        while(p <= down && q <= up) {
            if(a[p] <= a[q]) {
                out[o++] = a[p++];
            }
            else {
                out[o++] = a[q++];
            }
        }
        while(p <= down) {
            out[o++] = a[p++];
        }
        while(q <= up) {
            out[o++] = a[q++];
        }
        //transfer back
        for(int i = 0; i < out.length; i++) {
            a[(l * chunkSize) + i] = out[i];
        }
    }
}
