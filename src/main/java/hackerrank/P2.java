package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author nalin.sharma on 14/06/21
 *
 * List<Integer> arrival = Arrays.asList(7,1,2,12,5,6,30,32);
 * List<Integer> load = Arrays.asList(15,10,10,10,10,15,10);
 * servers 3
 *
 *    Arrival  Load  Finish  Server
 *      7       15
 *
 */
public class P2 {
    static class Wrapper {
        Wrapper(int s, int l, int f) {
            server = s;
            load = l;
            finish = f;
        }
        int server;
        int load;
        int finish;
    }
    public static List<Integer> loadBalancing(int k, List<Integer> arrival, List<Integer> load)     {
        // Write your code here
        Queue<Wrapper> q = new PriorityQueue<>((w1,w2) -> {
            return Integer.compare(w1.finish, w2.finish);
        });
        int time = 1;
        int[] max = {0};
        for( ; time <= k; time++) {
            if(max[0] < load.get(time-1)) {
                max[0] = load.get(time-1);
            }
            q.add(new Wrapper(time, load.get(time-1),  load.get(time-1) + (time-1)));
        }

        while(time < arrival.size()) {
            int newR = load.get(time-1) + (time-1);
            if(q.peek().finish < newR) {
                Wrapper w =  q.remove();
                w.load += load.get(time-1);
                w.finish += (load.get(time-1) + (time - 1));
                if(max[0] < w.finish) {
                    max[0] = w.finish;
                }
                q.add(w);
            }
            time++;
        }
        List<Integer> out = new ArrayList<>();
        return out.stream().filter(i-> i == max[0]).sorted().collect(Collectors.toList());
    }
    public static void main(String[] args) {

        List<Integer> arrival = Arrays.asList(7,1,2,12,5,6,30,32);
        List<Integer> load = Arrays.asList(15,10,10,10,10,15,10);
        System.out.println(loadBalancing(3, arrival, load));
    }
}
