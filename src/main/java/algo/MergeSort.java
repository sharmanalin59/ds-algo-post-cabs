package algo;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int a[] = {3,2,4,1,2};
        sort(a,0,a.length-1);
        Arrays.stream(a).forEach(System.out::println);
    }

    private static void sort(int[] a, int l, int h) {
        if(h>l) {
            int mid = (l+h)/2;
            sort(a,l,mid);
            sort(a,mid+1,h);

            //merge
            merge(a,l,mid,h);
        }
    }

    private static void merge(int[] a, int l, int mid, int h) {
        int tmp [] = new int [h-l+1];
        int m = 0, p = l, q = mid+1;
        while(p <= mid && q <= h) {
            if(a[p] <= a[q]) {
                tmp[m++] = a[p++];
            }
            else {
                tmp[m++] = a[q++];
            }
        }
        while(p <= mid) {
            tmp[m++] = a[p++];
        }
        while(q <= h) {
            tmp[m++] = a[q++];
        }
        //transfer back
        m = 0;
        while(m < tmp.length) {
            a[l+m] = tmp[m++];
        }
    }
}
