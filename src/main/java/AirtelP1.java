import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author nalin.sharma on 17/09/21
 *
 *
 *
 * You are playing an elves memory game. Your input is a series of starting numbers
 * The game has the following rules
 * 1. They begin by taking turns reading from a list of starting numbers
 * 2. Then each turn consists of considering the most recently spoken number
 *  - If that was the first time the number has been spoken, the current player says 0.
 *  - Otherwise, the number had been spoken before; the current player announces how many turns apart the number is from when it was previously spoken.
 *
 * For example, suppose the starting numbers are 0,3,6:
 *
 * Turn 1: The 1st number spoken is a starting number, 0.
 * Turn 2: The 2nd number spoken is a starting number, 3.
 * Turn 3: The 3rd number spoken is a starting number, 6.
 * Turn 4: Now, consider the last number spoken, 6. Since that was the first time the number had been spoken, the 4th number spoken is 0.
 * Turn 5: Next, again consider the last number spoken, 0. Since it had been spoken before, the next number to speak is the difference between the turn number when it was last spoken (the previous turn, 4) and the turn number of the time it was most recently spoken before then (turn 1). Thus, the 5th number spoken is 4 - 1, 3.
 * Turn 6: The last number spoken, 3 had also been spoken before, most recently on turns 5 and 2. So, the 6th number spoken is 5 - 2, 3.
 * Turn 7: Since 3 was just spoken twice in a row, and the last two turns are 1 turn apart, the 7th number spoken is 1.
 * Turn 8: Since 1 is new, the 8th number spoken is 0.
 * Turn 9: 0 was last spoken on turns 8 and 4, so the 9th number spoken is the difference between them, 4.
 * Turn 10: 4 is new, so the 10th number spoken is 0.
 *
 * What will be the 2020th number spoken?
 *
 * 0,3,6,0,3(4-1),3(5-2),1(6-5),0,
 *
 */
public class AirtelP1 {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> f = new ArrayList<>();
        f.add(1);
        List<Integer> s = new ArrayList<>();
        s.add(2);
        List<Integer> t = new ArrayList<>();
        t.add(3);
        map.put(0,f);
        map.put(3,s);
        map.put(6,t);
        int diff;
        int last = 6, n = 9, cnt = 4;

        //0,3,6,0,3(4-1),3(5-2),1(6-5),0
        while(cnt <= n) {
            if(map.get(last).size() == 1) {
                addToMapList(map, 0, cnt);
                last = 0;
            }
            else if(map.get(last).size() == 2) {
                diff = map.get(last).get(1) - map.get(last).get(0);
                addToMapList(map, diff, cnt);
                last = diff;
            }
            cnt++;
        }
        System.out.println(last);
    }

    private static void addToMapList(Map<Integer, List<Integer>> map, int key, int val) {
        if(!map.containsKey(key)) {
            List<Integer> t = new ArrayList<>();
            t.add(val);
            map.put(key,t);
        }
        else if(map.get(key).size() == 1) {
            map.get(key).add(val);
        }
        else if(map.get(key).size() == 2) {
            map.get(key).add(val);
            map.get(key).remove(0);
        }
    }
}
