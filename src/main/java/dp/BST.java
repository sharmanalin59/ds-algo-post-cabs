package dp;

import java.util.*;

/**
 * @author nalin.sharma on 17/09/21
 */
public class BST {
    /**
     *
     */
    static class Node {
        Node(int i) {
            this.i = i;
        }
        int i;
        Node l,r;
    }

    /*static Node add(Node start, int item) {
        if(start == null) {
            start = new Node(item);
        }
        if(start.l != n) {

        }

        [3,9,20,null,null,15,7]

             3
           9   20
             15  7

    }*/

    static class Wrapper {

        public Wrapper(Node node, int level) {
            this.node = node;
            this.level = level;
        }

        Node node;
        int level;

    }
    public static void main(String[] args) {
        Node start = new Node(3);
        start.l = new Node(9);
        start.r = new Node(20);
        start.r.l = new Node(15);
        start.r.r = new Node(7);


        List<List<Integer>> out = bfs(start);
        System.out.println(out);
    }

    private static List<List<Integer>> bfs(Node start) {
        if(start == null) {
            return null;
        }
        Queue<Wrapper> q = new LinkedList<>();
        q.add(new Wrapper(start,0));
        System.out.println();
        Map<Integer, List<Integer>> out = new HashMap<>();
        while(!q.isEmpty()) {
            Wrapper removed = q.remove();
            if(!out.containsKey(removed.level)) {
                out.put(removed.level, new ArrayList<>());
            }
            out.get(removed.level).add(removed.node.i);

            if(removed.node.l != null) {
                q.add(new Wrapper(removed.node.l, removed.level + 1));
            }
            if(removed.node.r != null) {
                q.add(new Wrapper(removed.node.r, removed.level + 1));
            }
        }
        return new ArrayList<>(out.values());
    }
}
