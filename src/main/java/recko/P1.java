package recko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author nalin.sharma on 04/09/21
 */
public class P1 {
    public static void main(String[] args) {

        //List<> l = new ArrayList<>();
        String s = "abc";
        HashSet<String> set = new HashSet<>();
        per(s.toCharArray(), 0, set);
        System.out.println(set);
    }

    private static void per(char [] arr, int ind, HashSet<String> set) {
        if(ind == arr.length) {
            set.add(new String(arr));
            return;
        }
        char tmp;
        for(int i = ind; i < arr.length; i++) {
            tmp = arr[i];
            arr[i] = arr[ind];
            arr[ind] = tmp;
            per(Arrays.copyOf(arr, arr.length), ind + 1, set);
        }
    }
}
