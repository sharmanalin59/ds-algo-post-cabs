package graph;

import java.util.*;

/**
 * @author nalin.sharma on 17/06/21
 */
public class TopologicalSort {
    static class Graph {
        Graph(int m) {
            n = m;
            init();
        }
        int n;
        List<List<Integer>> adj = new ArrayList<>();
        void init() {
            for(int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
        }
        void addEdge(int frm, int to) {
            adj.get(frm).add(to);
        }

        void topologicalSort() {
            //start at 1
            boolean visited[] = new boolean[n+1];
            Deque<Integer> stack = new LinkedList<>();
            for(int i = 1; i < visited.length; i++) {
                if(!visited[i]) {
                    dfs(i, adj, visited, stack);
                }
            }
            while(!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }

        private void dfs(int i, List<List<Integer>> adj, boolean[] visited, Deque<Integer> stack) {
            if(!visited[i]) {
                visited[i] = true;
                for(int j = 0; j < adj.get(i).size(); j++) {
                    if(!visited[adj.get(i).get(j)]) {
                        dfs(adj.get(i).get(j), adj, visited, stack);
                    }
                }
                stack.push(i);
            }
        }

        public static void main(String[] args) {
            /**
             * Graph from Tushar Roy video
             * https://www.youtube.com/watch?v=ddTC4Zovtbc
             */
            Graph g = new Graph(8);
            g.addEdge(1,3);
            g.addEdge(2,3);
            g.addEdge(2,4);
            g.addEdge(3,5);
            g.addEdge(4,6);
            g.addEdge(5,6);
            g.addEdge(6,7);
            g.addEdge(5,8);
            g.topologicalSort();
        }
    }
}
