package algo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer {
    public static void main(String[] args) {

        /*List<Character> bL = new LinkedList<>();
        //bL.addFirst('0');


        int [] arr = {0,1,0,1};
        Map<Integer, Integer> map = new HashMap<>();
        int [] out = new int[1];
        int j[] = {0};
        map.forEach((k,v) -> {out[j[0]++] = v});

        int out = -1, sum = 0;
        //fill the map
        for(int i = 0; i< arr.length; i++) {
            if (arr[i] == 0) {
                sum -= 1;
            }
            else {
                sum += 1;
            }

            map.put(sum, i);
        }

        //update the zero length
        if(map.containsKey(0)) {
            out = map.get(0) + 1;
        }
        sum = 0;

        //runt the loop to find the =zrero length at each staring index now
        for(int i = 0; i< arr.length; i++) {
            if (arr[i] == 0) {
                //consider -1 and look for
                sum -= 1;
            }
            else {
                sum += 1;
                //consider -1 sum here
            }
            if (map.containsKey(sum) && (map.get(sum) - i > out)) {
                out = map.get(sum) - i;
            }
        }
        System.out.println(out);*/
    }
}
