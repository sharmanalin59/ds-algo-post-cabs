package algo.thoughtspot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P1 {
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
        /*List<Integer> gFrom = Arrays.asList(1,2,1,3,1,2);
        List<Integer> gTo =   Arrays.asList(2,3,3,5,4,6);
        nodeDistance(6, gFrom,gTo);*/
        List<Integer> gFrom = Arrays.asList(1,2,1,3,1,2,5);
        List<Integer> gTo =   Arrays.asList(2,3,3,5,4,6,7);
        nodeDistance(7, gFrom,gTo);
    }

    private static void nodeDistance(int size, List<Integer> gFrom, List<Integer> gTo) {
        int [][] adj = new int[size+1][size+1];

        for(int i = 0; i < gFrom.size(); i++) {
            adj[gFrom.get(i)][gTo.get(i)] = 1;
            adj[gTo.get(i)][gFrom.get(i)] = 1;
        }

        boolean visited [] = new boolean[size+1];
        Set<Integer> nodesCollected = new HashSet<>();
        boolean cycle = false;
        for(int i = 1; i < visited.length; i++) {
            if(!visited[i]) {
                nodesCollected = new HashSet<>();
                cycle = isCycle(adj, nodesCollected, visited, i, i);
                if(cycle) {
                    break;
                }
            }
        }
        if(cycle) {
          System.out.println(nodesCollected);
        }
        //nodesCollected
        Set<Integer> nodes;
        for(int i = 1; i < visited.length; i++) {
            nodes = new HashSet<>();
            distance(adj, nodesCollected, nodes, i);
            System.out.println("Node ["+i+"] distance:"+(nodes.size()-1));
        }
        /*for(int i = 1; i < adj.length; i++) {
            for(int j = 1; j < adj[0].length; j++) {

            }
        }*/
    }

    private static boolean distance(int[][] adj, Set<Integer> cycle, Set<Integer> nodesCollected, int ind) {
        if(nodesCollected.contains(ind)) {
            return false;
        }
        else {
            nodesCollected.add(ind);
        }
        if(cycle.contains(ind)) {
            return true;
        }

        for (int i = 1; i < adj.length; i++) {
            if (i != ind && adj[ind][i] == 1) {
                if(distance(adj, cycle, nodesCollected, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycle(int[][] adj, Set<Integer> nodesCollected, boolean[] visited, int ind, int org) {
        if(!visited[ind]) {
            visited[ind] = true;
            nodesCollected.add(ind);
            for (int i = 1; i < adj.length; i++) {
                if (i != ind && adj[ind][i] == 1) {
                    if(i == org && nodesCollected.size() > 2)
                        return true;
                    if(i == org && nodesCollected.size() <= 2)
                        continue;
                    return isCycle(adj, nodesCollected, visited, i, org);
                }
            }
            Math.pow(1,1);
        }
        return false;
    }
}
