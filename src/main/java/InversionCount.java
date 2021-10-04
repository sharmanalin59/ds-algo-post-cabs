/**
 * @author nalin.sharma on 20/09/21
 *
 *
 *    1  4  2  5  3  6  8  7
 *    1 2 4 8
 *    O(n) log2 n
 */
public class InversionCount {
    public static void main(String[] args) {
        int [] a = {3, 4, 6, 2, 1};
        int cnt [] = {0};
        divide(a, 0, a.length - 1, cnt);
        System.out.println(cnt[0]);
    }

    private static void divide(int[] a, int l, int h, int[] cnt) {
        if(l >= h) {
            return;
        }
        int mid = (l + h)/2;
        divide(a, l, mid, cnt);
        divide(a,mid+1, h, cnt);

        merge(a,l,mid,h, cnt);
    }

    private static void merge(int[] a, int l, int mid, int h, int[] cnt) {
        int p = l, q = mid + 1, ind = 0;
        int out [] = new int[h-l + 1];
        while(p <= mid && q <= h) {
            if(a[q] < a[p]) {
                out[ind++] = a[q++];
                //cnt
                cnt[0] += (mid - p + 1);
            }
            else {
                out[ind++] = a[p++];
            }
        }
        while(p <= mid) {
            out[ind++] = a[p++];
        }
        while(q <= h) {
            out[ind++] = a[q++];
        }
        //transfer back
        for(int i = 0; i < out.length; i++) {
            a[l+i] = out[i];
        }
    }
}
