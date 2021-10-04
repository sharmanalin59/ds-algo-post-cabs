package algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nalin.sharma on 01/09/21
 */
public class SmallestNumberGreaterThanNumber {
    static void findByReverse(String s) {
        System.out.println("findByReverse start");
        int ind = -1, eleGrtInd = -1;
        for(int i = s.length() - 2; i >= 0; i--) {
            if(s.charAt(i) < s.charAt(i+1)) {
                ind = i;
                break;
            }
        }
        if(ind != -1) {
            char [] arr = s.toCharArray();
            for(int i = arr.length - 1; i > ind; i--) {
                if (arr[i] > arr[ind]) {
                    swap(arr, ind, i);
                    break;
                }
            }
            reverse(arr, ind +1, arr.length - 1);
            System.out.println(arr);
        }
        System.out.println("findByReverse end");
    }

    private static void swap(char[] arr, int l, int h) {
        char tmp = arr[l];
        arr[l] = arr[h];
        arr[h] = tmp;
    }
    private static void reverse(char[] arr, int l, int h) {
        if(h >= l) {
            swap(arr, l, h);
            reverse(arr, l + 1, h -1 );
        }
    }

    public static void main(String[] args) {
        String s = "536976";
        findByReverse(s);
        int ind = -1, eleGrtInd = -1;
        for(int i = s.length() - 2; i >= 0; i--) {
            if(s.charAt(i) < s.charAt(i+1)) {
                ind = i;
                break;
            }
        }
        if(ind != -1) {
            for(int j = s.length() - 1; j > ind; j--) {
                if((eleGrtInd == -1 || s.charAt(eleGrtInd) > s.charAt(j))
                        && s.charAt(j) > s.charAt(ind)) {
                    eleGrtInd = j;
                }
            }
            //replace
            char arr [] = s.toCharArray();
            char tmp = arr[ind];
            arr[ind] = arr[eleGrtInd];
            arr[eleGrtInd] = tmp;
            Map<Character, Integer> map = new HashMap<>();
            for(int z = ind+1; z < arr.length; z++) {
                if(map.containsKey(arr[z])) {
                    map.put(arr[z], map.get(arr[z]) + 1);
                }
                else {
                    map.put(arr[z], 1);
                }
            }
            for(int z = ind+1; z < arr.length; z++) {
                int num = '0', cnt = 9, cInd = ind+1;
                for(int c = 0; c <= cnt; c++) {
                    if(map.containsKey((char)(c + '0'))) {
                        for(int m = map.get((char)(c + '0')); m > 0; m--) {
                            arr[cInd++] = (char) (c + '0');
                        }
                    }
                }
            }
            //Arrays.sort(arr,ind+1, arr.length);
            String out = new String(arr);
            System.out.println(out);
        }
    }
}
