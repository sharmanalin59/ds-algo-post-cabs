package graph;

import java.util.*;

/**
 * @author nalin.sharma on 04/07/21
 *
 *          2
 *        2 -- 4
 *       /2
 *     1
 *      \3
 *       3 -- 5
 *         2
 *
 *         Disjoint set
 *         1   2   3   4
 *         1(1)    3(1)
 *         |       |
 *         2       4
 *
 *         1(2)
 *         |  \
 *         2   3 - 4
 *
 */
public class Kruskal {
    static class DS {
        int size = 10;
        Map<Integer, Node> map = new HashMap<>();

        public DS(int s) {
            size = s;
            init();
        }

        void init() {
            for(int i = 0; i < size; i++) {
                Node n = new Node(0, i+1);
                n.parent = n;
                map.put(i+1, n);
            }
        }

        Node findRoot(Node i) {
            if(i == i.parent) {
                return i;
            }
            Node res = findRoot(i.parent);
            i.parent = res; //path compression
            return res;
        }

        void union(int a, int b) {
            Node aRoot = findRoot(map.get(a));
            Node bRoot = findRoot(map.get(b));
            if(aRoot.rank > bRoot.rank) {
                bRoot.parent = aRoot;
            }
            else if(aRoot.rank < bRoot.rank) {
                aRoot.parent = bRoot;
            }
            else {
                bRoot.parent = aRoot;
                aRoot.rank++;
            }
        }

        static class Node {
            Node(int r, int n) {
                rank = r;
                num = n;
            }
            int rank, num; //rank height
            Node parent;
        }

    }
    public static void main(String[] args) {
        DS ds = new DS(6);
        ds.union(1,2);
        ds.union(1,3);

        ds.union(4,5);
        ds.union(5,6);

        ds.union(1,5);
    }
}
