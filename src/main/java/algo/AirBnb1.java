package algo;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;

/**
 * @author nalin.sharma on 01/10/21
 */
public class AirBnb1 {
    public static void main(String[] args) {
        List<Integer> candyPiles = new ArrayList<>();
        candyPiles.add(23);
        candyPiles.add(30);
        candyPiles.add(11);
        candyPiles.add(20);
        candyPiles.add(4);
        System.out.println("ans "+minimumCandiesPerHour(candyPiles, 6));
    }

    public static int minimumCandiesPerHour(List<Integer> candyPiles, int numHours) {
        // Write your code here
        //Integer arr [] = {5, 2, 6, 8, 9};
        int k, H = 8;
        int [] ans = {0};

        /*int c = 1/0;
        System.out.println(c);*/
        //Arrays.sort(arr, Collections.reverseOrder());
        candyPiles.sort(Collections.reverseOrder());
        System.out.print(numHours+" candies ");
        for (int i = 0; i < candyPiles.size(); i++) {
            System.out.print(candyPiles.get(i)+" ");
        }
        ans[0] = k = candyPiles.get(0);
        if(candyPiles.size() > H) {
            System.out.println("not possible");
            return -1;
        }
        binarySearch(1, k, candyPiles, ans, H);
        return ans[0];
    }

    private static void binarySearch(int l, int h, List<Integer> candyPiles, int[] ans, int H) {
        if(l > h) {
            return;
        }
        int mid = (l + h)/2;
        if(isPossible(mid, candyPiles, H)) {
            ans[0] = mid;
            binarySearch(l, mid-1, candyPiles, ans, H);
        }
        else {
            binarySearch(mid+1, h, candyPiles, ans, H);
        }
    }

    private static boolean isPossible(int mid, List<Integer> candyPiles, int H) {
        int cnt = 0;
        for (int i = 0; i < candyPiles.size(); i++) {
            cnt += (candyPiles.get(i) / mid);
            if(candyPiles.get(i) % mid > 0) {
                cnt++;
            }
        }
        return cnt <= H;
    }
}
