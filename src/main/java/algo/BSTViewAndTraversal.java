package algo;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BSTViewAndTraversal {
    private static class Node {
        int d;
        Node l;
        Node r;
        Node(int j) {
            d = j;
        }
    }
    static Node add(Node start, int i) {
        if(start == null) {
            start = new Node(i);
        }
        else if(start.l != null && i <= start.d) {
            add(start.l,i);
        }
        else if(start.l == null && i <= start.d) {
            start.l = new Node(i);
        }
        else if(start.r != null && i > start.d) {
            add(start.r,i);
        }
        else if(start.r == null && i > start.d) {
            start.r = new Node(i);
        }
        return start;
    }

    static void show(Node start) {
        if(start != null){
            show(start.l);
            System.out.println(start.d);
            show(start.r);
        }
    }

    static class BVWrap{
        BVWrap(int v, int val) {
            vert = v;
            value = val;
        }
        int vert;
        int value;
    }
    static void bottomView(Node start) {
        Map<Integer,BVWrap> map = new HashMap<>();
        bv(start, 0, 0, map);
        map.forEach((k,v) -> System.out.println(v.value));
    }

    private static void bv(Node start, int i, int j, Map<Integer,BVWrap> map) {
        if(null != start) {
            if (!map.containsKey(i)) {
                map.put(i, new BVWrap(j, start.d));
            } else if (map.get(i).vert < j) {
                BVWrap bv = map.get(i);
                bv.vert = j;
                bv.value = start.d;
            }
            bv(start.l, i - 1, j + 1, map);
            bv(start.r, i + 1, j + 1, map);
        }
    }

    static void lca(Node start, int i, int j) {
        System.out.println("LCA....");
        Node found = lca_private(start, i, j);
        if(found == null) {
            System.out.println("-");
            return;
        }

        if (found.d != i && found.d != j) {
            System.out.println(found.d);
            return;
        }

        boolean f = false;
        if (found.d == i) {
            f = find(found,j);
        }
        else if (found.d == j) {
            f = find(found,i);
        }
        if(f) {
            System.out.println(found.d);
        }
    }

    private static boolean find(Node start, int i) {
        if (start != null) {
            return (i == start.d) || find(start.l, i) || find(start.r, i);
        }
        return false;
    }

    static Node lca_private(Node start, int i, int j) {
        if(null != start) {
            if (start.d == i || start.d == j) {
                return start;
            }
            Node left = lca_private(start.l, i, j);
            Node right = lca_private(start.r, i, j);
            if(left != null && right != null) {
                return start;
            }
            else if (left != null) {
                return left;
            }
            else if (right != null) {
                return right;
            }
        }
        return null;
    }

    static void isCousin(Node start, int i, int j) {
        Node parentI = null, parentJ = null;
        DP iDP = depthAndParent(start, i, parentI);
        DP jDP = depthAndParent(start, j, parentJ);
        if(iDP != null && jDP != null &&
                iDP.depth != -1 && jDP.depth != -1 &&
                iDP.depth == jDP.depth &&
                iDP.parent != jDP.parent) {
            System.out.println("cousin");
        }
        else {
            System.out.println("not cousin");
        }
    }
    static class DP {
        DP(int d, Node p) {
         depth = d;
         parent = p;
        }
        int depth;
        Node parent;
    }

    static private DP depthAndParent(Node start, int item, Node parent) {
        if(null != start) {
            if(item == start.d) {
                return new DP(1, parent);
            }
            DP l = depthAndParent(start.l, item, start);
            DP r = depthAndParent(start.r, item, start);
            if(l == null && r == null) {
                return null;
            }
            else if (l!=null){
                l.depth++;
                return l;
            }
            else {
                r.depth++;
                return r;
            }
        }
        return null;
    }

    //given pre order find if bst is possible
    static void isBSTFromPreOrder(int [] pre) {
        //6,4,1,2,3,5,7,8,9
        //6,4,1,2,3,5,7,8,9
        /*
              6

          4         7
       1      5         9
         2             8
           3


         */
        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> queue = new LinkedList<>();
        stack.push(pre[0]);
        int i = 1;
        while(i < pre.length) {
            while (i < pre.length && pre[i] < pre[i - 1]) {
                stack.push(pre[i]);
                i++;
            }

            if(i < pre.length) {
            while(!stack.isEmpty() && stack.peek() < pre[i]) {
                int pop = stack.pop();
                queue.add(pop);
            }
                stack.push(pre[i++]);
            }

        }

        while(!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        int last = queue.remove();
        System.out.println(last);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            if(current < last){
                System.out.println("pre order is wrong");
                break;
            }
            System.out.println(current);
            last = current;
        }
        if(queue.isEmpty()) {
            System.out.println("pre order is correct");
        }


    }
    public static void main(String[] args) {
        Node start = null;
        start = add(start, 6);
        start = add(start, 4);
        start = add(start, 5);
        start = add(start, 1);
        start = add(start, 2);
        start = add(start, 3);
        start = add(start, 7);
        start = add(start, 9);
        start = add(start, 8);
        show(start);

        //pre order
        Deque<Node> stack = new LinkedList<>();
        Node tmp = start;
        stack.push(start);
        while(!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop);
            if(pop.r != null)
            stack.push(pop.r);
            if(pop.l != null)
                stack.push(pop.l);
        }

        //view
        bottomView(start);
        lca(start, 3,4);
        isCousin(start, 100,8);

        int [] preO = {6,4,1,2,3,5,7,8,9};
        //int [] preO = {6,3,1,2};
        isBSTFromPreOrder(preO);
    }
}
