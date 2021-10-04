package graph;

import java.util.*;

/**
 * @author nalin.sharma on 04/06/21
 */
public class SortCount {
    public static void main(String[] args) {
        int arr[] = {5,44,55,22,33};
        int j= 0;
        int cnt;
        while(j < arr.length) {
            cnt = 0;
            for(int i = 0; i < arr.length; i++) {
                if(i != j && arr[i] < arr[j]) {
                    cnt++;
                }
            }
            if(cnt > 0 && j != cnt) {
                //swap
                int tmp = arr[cnt];
                arr[cnt] = arr[j];
                arr[j] = tmp;
;            }
            else {
                j++;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }


        TreeMap<Integer, TreeSet<Integer>> houseByArea = new TreeMap<>();

        Map<Integer, List<Integer>> houseByAreaMaster = new TreeMap<>();
        houseByAreaMaster.forEach((k,v) -> {
            Collections.sort(v);
        });

        Map.Entry<Integer,TreeSet<Integer>> pricesEntry = houseByArea.ceilingEntry(1);

    }
}
