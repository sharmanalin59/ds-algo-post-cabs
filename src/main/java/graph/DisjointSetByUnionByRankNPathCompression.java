package graph;

import java.util.*;

/**
 * @author nalin.sharma on 15/06/21
 */
public class DisjointSetByUnionByRankNPathCompression {
    public static class DSByUnion {
        public DSByUnion(int n) {
            num = n;
            makeSet();
        }
        int num = 6;
        Map<Integer,Node> map = new HashMap<>();
        public void makeSet() {
            for(int i = 0; i <num; i++) {
                Node n = new Node(i+1,0);
                n.parent = n;
                map.put(i+1, n);
            }
        }

        public void union(int a1, int a2) throws RuntimeException {
            Node a = map.get(a1);
            Node b = map.get(a2);
            Node aParent = findRoot(a,a);
            Node bParent = findRoot(b,b);
            if(aParent != null && bParent != null) {
                //merge
                if(aParent == bParent) {
                    throw new RuntimeException("Cycle detected");
                }
                if(aParent.rank == bParent.rank) {
                    bParent.parent = aParent;
                    aParent.rank++;  //Important
                }
                else if(aParent.rank > bParent.rank) {
                    bParent.parent = aParent;
                }
                else {
                    aParent.parent = bParent;
                }
                return;
            }
            throw new RuntimeException("Not found");
        }

        public int findRoot(int item) {
            if(!map.containsKey(item)) {
                return -1;
            }
            return findRoot(map.get(item), map.get(item)).num;
        }
        public Node getElement(int i) {
            return map.get(i);
        }
        public Node findRoot(Node item, Node original) {
            if(item == null) {
                return null;
            }
            if(item.parent == item) {
                //path compression
                original.parent = item;
                return item;
            }
            return findRoot(item.parent, original);
        }

        public static class Node {
            Node(int n, int r) {
                num = n;
                rank = r;
            }
            public int num;
            public int rank; //height
            public Node parent;

            @Override
            public String toString() {
                return "Node{" +
                        "num=" + num +
                        ", rank=" + rank +
                        '}';
            }
        }
    }
    public static void main(String[] args) {
        DSByUnion ds = new DSByUnion(7);
        ds.union(1,2);
        ds.union(3,4);
        System.out.println(ds.findRoot(4));
    }
}
