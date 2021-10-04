import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nalin.sharma on 03/09/21
 */
public class MinSweeps {
    public static void main(String[] args) {
        int arr [] = {2,1,3,4};
        int sortedArr [] = Arrays.copyOf(arr, arr.length);
        int minSwaps = 0;
        /*Character a = new Character('a');
        Character A = new Character('A');
        System.out.println((int)a+""+(int)'z'+(int)A);*/
        //List<Integer> l = Arrays.asList(arr);
        /*
        2,3,4,1
         2,1,3,4
         1,2,3,4
         */
        Arrays.sort(sortedArr);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < sortedArr.length; i++) {
            map.put(sortedArr[i], i);
        }
        for(int i = 0; i < arr.length; i++) {
            int sortedInd = map.get(arr[i]);
            //swap
            int tmp = arr[i];
            arr[i] = arr[sortedInd];
            arr[sortedInd] = tmp;
            minSwaps++;
        }

    }
}
