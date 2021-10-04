package graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author nalin.sharma on 16/06/21
 *
 * works for undirected graph
 *
 */
public class Kruskarl_MST {
    static class Graph {

        int n;
        List<Map<Integer, Integer>> adj = new ArrayList<>();

        public Graph(int m) {
            n = m;
            init();
        }
        void init() {
            for(int i = 0; i <= n; i++ ) {
                adj.add(new HashMap<>());
            }
        }

        public void addEdge(int i, int j, int wt) {
            adj.get(i).put(j, wt);
            adj.get(j).put(j, wt);
        }

        static class Edge{
            public Edge(int i, int j, int w) {
                from = i;
                to = j;
                wt = w;
            }
            int from, to, wt;

            @Override
            public String toString() {
                return "Edge{" +
                        "from=" + from +
                        ", to=" + to +
                        ", wt=" + wt +
                        '}';
            }
        }

        void kruskal_mst() {
            DisjointSetsByUnionRankNPathCompression ds = new DisjointSetsByUnionRankNPathCompression(n);
            PriorityQueue<Edge> q = new PriorityQueue<>((a,b) -> Integer.compare(a.wt, b.wt));
            int cnt[] = {0};
            //adj.stream().map(Map::entrySet).flatMap(Set::stream).collect(Collectors.toList());
            for(Map<Integer, Integer> map :adj) {
                if(cnt[0] == 0) {
                    cnt[0]++;
                    continue;
                }
                map.forEach((k,v) -> {
                    q.add(new Edge(cnt[0], k, v));
                });
                cnt[0]++;
            }
            int mst = 0;
            List<Edge> mst_l = new ArrayList<>();
            while(!q.isEmpty()) {
                Edge e = q.remove();
                if(ds.isCycle(e.from, e.to)) {
                    continue;
                }
                mst += e.wt;
                mst_l.add(e);
            }
            System.out.println("MST cost : "+mst);
            System.out.println("MST edges involved ");
            mst_l.forEach(System.out::println);
        }
    }

    static class DisjointSetsByUnionRankNPathCompression {
        //makeSet, find, union
        public DisjointSetsByUnionRankNPathCompression(int nodes) {
            for(int i = 1; i <= nodes; i++ ) {
                Node node = new Node(i, 0);
                node.parent = node;
                map.put(i, node);
            }
        }
        static class Node {
            Node(int i, int j) {
                num = i;
                rank = j;
            }
            int num;
            int rank;
            Node parent;
        }
        Map<Integer, Node> map = new HashMap<>();

        public Node findRoot(Node n, Node original) {
            if(n == null) {
                return null;
            }
            if(n.parent == n) {
                //path compression
                original.parent = n; //make direct child of root
                return n;
            }
            return findRoot(n.parent, original);
        }
        public boolean isCycle(int aN, int bN) {
            try {
                union(aN, bN);
            } catch (RuntimeException e) {
                if(e.getMessage().equals("Cycle")) {
                    return true;
                }
                else {
                    throw e;
                }
            }
            return false;
        }
        public void union(int aNum, int bNum) {
            Node a = map.get(aNum);
            Node b = map.get(bNum);
            Node aRoot = findRoot(a, a);
            Node bRoot = findRoot(b, b);
            if(aRoot == bRoot) {
                throw new RuntimeException("Cycle");
            }
            if(aRoot != null && bRoot != null) {
                if(aRoot.rank == bRoot.rank) {
                    bRoot.parent = aRoot;
                    aRoot.rank++;
                }
                else if(aRoot.rank > bRoot.rank) {
                    bRoot.parent = aRoot;
                }
                else {
                    aRoot.parent = bRoot;
                }
                return;
            }
            throw new RuntimeException("Not Found");
        }
    }



    public static void main(String[] args) {
        /*
        https://www.google.com/search?q=mst+graph&rlz=1C5CHFA_enIN905IN905&sxsrf=ALeKk01gGAIMCeYU0h8EV13Kv5CjXtzyTg:1623871679164&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiKn-O08ZzxAhWPzzgGHSeJCuYQ_AUoAXoECAEQAw&biw=1440&bih=717#imgrc=0n83A3UBqvE7jM
         */
        Graph g = new Graph(6);
        g.addEdge(1,4, 3);
        g.addEdge(1,2, 1);

        g.addEdge(2,4, 5);
        g.addEdge(4,5, 1);
        g.addEdge(2,5, 1);

        g.addEdge(2,3, 6);
        g.addEdge(3,5, 5);
        g.addEdge(3,6, 2);
        g.addEdge(5,6, 4);
        g.kruskal_mst();
    }
}
