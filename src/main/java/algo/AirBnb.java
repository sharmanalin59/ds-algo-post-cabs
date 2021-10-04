package algo;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author nalin.sharma on 01/10/21
 */
public class AirBnb {
    public static void main(String[] args) {
        Integer arr [] = {30, 23, 20, 11, 4};
        int k, H = 6;
        int [] ans = {0};

        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        ans[0] = k = arr[0];
        if(arr.length > H) {
            System.out.println("not possible");
            return;
        }
        binarySearch(1, k, arr, ans, H);
        System.out.println("ans "+ans[0]);
    }

    private static void binarySearch(int l, int h, Integer[] arr, int[] ans, int H) {
        if(l > h) {
            return;
        }
        int mid = (l + h)/2;
        if(isPossible(mid, arr, H)) {
            ans[0] = mid;
            binarySearch(l, mid-1, arr, ans, H);
        }
        else {
            binarySearch(mid+1, h, arr, ans, H);
        }
    }

    private static boolean isPossible(int mid, Integer[] arr, int H) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += (arr[i] / mid);
            if(arr[i] % mid > 0) {
                cnt++;
            }
        }
        return cnt <= H;
    }
}
