package algo.thoughtspot;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        /**
         *
         * [30,10,40,50,30]
         * days  = 2
         * total 80 = 30 (max 30 10) + 50 (max 40 50 30)
         *
         *
         */
        int arr[] = {30,10,40,50,30};
        int k = 3;
        int out [] = {0};
        List<Integer> output = new ArrayList<>();
        //rec(arr, 0, k, new ArrayList<>(),output ,0, out);
    }

    private String rec(int[] arr, int ind, int k, List<Integer> list, List<Integer> output, int sum, int[] out) {
        if(ind - arr.length + 1 <= 0) {
            return "";
        }
        for(int i = ind; i < (arr.length-k); i++) {
            int min = arr[ind];
            list.add(min);
            out[0] += arr[ind];

            if(list.get(list.size()-1) > arr[i]) {
                out[0] -= (list.get(list.size()-1)-arr[ind]);
                list.set(list.size()-1,arr[i]);
            }
           // rec(arr, 0, k, new ArrayList<>(),output ,0, out);
        }
        return null;
    }


}
