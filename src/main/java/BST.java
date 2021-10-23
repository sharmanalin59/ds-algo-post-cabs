/**
 * @author nalin.sharma on 13/10/21
 */
public class BST {
    static class Node {
        int i;

        public Node(int i) {
            this.i = i;
        }

        Node l,r;
    }

    static void show(Node start) {
        if(start != null) {
            System.out.print(start.i+" ");
            show(start.l);
            show(start.r);
        }
    }

    static Integer lca(Node start, int i, int j) {
        Node found = lcaUtil(start, i, j);
        if(found == null) {
            return null;
        }
        if(found.i == i) {
            if(find(found.l, j) || find(found.l, j)) {
                return found.i;
            }
            return null;
        }
        if(found.i == j) {
            if(find(found.l, i) || find(found.l, i)) {
                return found.i;
            }
            return null;
        }
        return found.i;
    }

    private static boolean find(Node start, int i) {
        if(start != null) {
            return start.i == i || find(start.l, i) || find(start.r, i);
        }
        return false;
    }

    static Node lcaUtil(Node start, int i, int j) {
        if(start != null) {
            if(start.i == i || start.i == j) {
                return start;
            }
            Node l = lcaUtil(start.l, i, j);
            Node r = lcaUtil(start.r, i, j);
            if(l != null && r != null) {
                return start;
            }
            return l != null ? l: r;
        }
        return null;
    }
    static boolean isBst(Node start, int l, int r) {
        return (start == null)
                || (start.i <= r && start.i > l
                && isBst(start.l, l, start.i)
                && isBst(start.r, start.i, r));
    }
    public static void main(String[] args) {
        Node start = new Node(3);
        start.l = new Node(4);
        start.r = new Node(4);
        show(start);
        System.out.println("lca "+lca(start, 2,2));
        System.out.println("isBst "+ isBst(start, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
