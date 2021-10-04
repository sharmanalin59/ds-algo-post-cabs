package slintel;

/**
 * @author nalin.sharma on 22/06/21
 * find mim elements to right
 * N logN
 */
public class MPL1 {
    static class Wrapper {
        Wrapper(int e, int i) {
            ele = e;
            index = i;
        }
        int ele, index;
    }
    public static void main(String[] args) {
        int arr [] = {10, 50, 30, 20, 40};
        Wrapper [] warr = new Wrapper[arr.length];
        for(int i = 0; i < arr.length; i++) {
            warr[i] = new Wrapper(arr[i], i);
        }
        int brr [] = new int[arr.length];

        sort(0, arr.length - 1, warr, brr);
        System.out.println("Input arr");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nOutput arr");
        for(int i = 0; i < brr.length; i++) {
            System.out.print(brr[i]+" ");
        }
    }

    /*
      8 .... (9 7 2  10 6 3
              p       q
        descending sort from back
     */
    private static void sort(int l, int h, Wrapper[] warr, int brr []) {
        if(h > l) {
            int mid = (l+h)/2;
            sort(mid + 1, h, warr, brr);
            sort(l, mid, warr, brr);

            merge(l, mid, h, warr, brr);
        }
    }

    private static void merge(int l, int mid, int h, Wrapper[] warr, int [] brr) {
        int p = l, q = mid + 1, out = 0;
        Wrapper tmp [] = new Wrapper[h-l + 1];
        while(p <= mid && q <= h) {
            if(warr[q].ele >= warr[p].ele) {
                tmp[out++] = warr[q++];
            }
            else {
                tmp[out++] = warr[p];
                brr[warr[p].index] += (h-q + 1);
                p++;
            }
        }
        while(p <= mid) {
            tmp[out++] = warr[p++];
        }
        while(q <= h) {
            tmp[out++] = warr[q++];
        }
        out = 0;
        while(out < tmp.length) {
            warr[l+out] = tmp[out++];
        }
    }
}
