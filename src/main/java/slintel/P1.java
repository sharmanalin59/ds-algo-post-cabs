package slintel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nalin.sharma on 21/06/21
 */
public class P1 {
    static class Graph {
        int n = 10;
        List<List<Integer>> adj = new ArrayList<>();
        void init() {
            for(int i = 0; i < 11; i++) {
                adj.add(new ArrayList<>());
            }
            adj.get(0).add(1);
            adj.get(1).add(0);
            adj.get(1).add(2);
            adj.get(2).add(1);
            adj.get(2).add(3);
        }
    }
    public static void main(String[] args) {

    }
}
