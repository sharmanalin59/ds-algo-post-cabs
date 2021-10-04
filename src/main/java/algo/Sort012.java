package algo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Sort012 {
    public static void main(String[] args) {
        int a [] = {2};
        int b [] = {1,0,0,0,0,0};
        sort01(b);
        Arrays.stream(b).forEach(System.out::println);

        System.out.println("hello");
        sort012(a);
        Arrays.stream(a).forEach(System.out::println);

        int c[] = {2,4,1,3,2,1,0};
        int best[] = new int[c.length];
        best[0] = 0;
        for(int i = 1; i < b.length; i++) {
            int min = 0;
            for(int bb = 0; bb < i; bb++) {

            }
        }
        Deque stack = new ArrayDeque();
    }

    private static void sort012(int[] a) {
        int l = 0, m = 0, r = a.length -1;
        while(m < r) {
            if(a[m] == 0) {
                int tmp = a[m];
                a[m] = a[l];
                a[l] = tmp;
                l++;
                m++;
            }
            else if(a[m] == 2) {
                int tmp = a[m];
                a[m] = a[r];
                a[r] = tmp;
                r--;
            }
            else {
                m++;
            }
        }
    }

    private static void sort01(int[] b) {
        if(b == null || b.length == 0) {
            System.out.println("empty");
            return;
        }
        int p = 0, q = b.length - 1;
        while(q > p) {
            while(p <= b.length - 1 && b[p] == 0) {
                p++;
            }
            while(q >= 0 && b[q] == 1) {
                q--;
            }
            if(q>p) {
                int tmp = b[p];
                b[p] = b[q];
                b[q] = tmp;
            }
        }
    }
}
