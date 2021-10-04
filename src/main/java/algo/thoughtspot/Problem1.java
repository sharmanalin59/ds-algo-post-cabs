package algo.thoughtspot;

import java.util.*;

import static algo.thoughtspot.Problem1.isCycle;

public class Problem1 {
    public static List<Integer> nodeDistance(int gNodes, List<Integer> gFrom, List<Integer> gTo) {
        int adj [][] = new int[gNodes+1][gNodes+1];
        for (int i = 1; i <= gFrom.size(); i++) {
            adj[gFrom.get(i-1)][gTo.get(i-1)] = 1;
            adj[gTo.get(i-1)][gFrom.get(i-1)] = 1;
        }
        Set<Integer> cycle = new HashSet<>();

        for (int i = 1; i < adj.length; i++) {
            cycle = isCycle(adj,new HashSet<>(),i,i);
            if(cycle != null) {
                break;
            }
        }
        System.out.println(cycle);

        List<Integer> output = new ArrayList<>();
        for(int i = 1; i < adj.length; i++){
            output.add(traverse(adj, cycle, new HashSet<>(), 0, i));
        }
        return output;
    }

    static int traverse(int adj [][], Set<Integer> cycle, Set<Integer> current, int cnt , int curr)
    {
        if(cycle.contains(curr)) {
            return cnt;
        }
        current.add(curr);
        for(int i = 1; i < adj.length; i++){
            if(!current.contains(curr) && i != curr && adj[curr][i] == 1) {
                return traverse(adj,cycle,current, cnt + 1, curr);
            }
        }
        return 0;
    }

    static Set<Integer> isCycle(int adj [][], Set<Integer> cycle, int curr, int original) {
        cycle.add(curr);
        for(int i = 1; i < adj.length; i++) {
            if(adj[curr][i] == 1 && i == original && cycle.size() > 2) {
                return cycle;
            }
            else if(curr != i && !cycle.contains(i) && adj[curr][i] == 1) {
                Set<Integer> ret = isCycle(adj, new HashSet<>(cycle), i, original);
                if(ret != null) {
                    return ret;
                }
            }
        }
        return null;
    }

    /**
     *
     *    4  o--- 1   ----- o 2 ---o 6
     *            \         |
     *              \      |
     *                o   o
     *                  3 ----o 5
     *
     *
     *
     */
    public static void main(String[] args) {
        List<Integer> gFrom = Arrays.asList(1,2,1,3,1,2);
        List<Integer> gTo =   Arrays.asList(2,3,3,5,4,6);
        nodeDistance(6, gFrom,gTo);
    }
}
