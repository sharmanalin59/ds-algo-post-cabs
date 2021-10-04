package algo;

public class BST {
    public static class Node<T> {
        Node(int t) {
            c = t;
        }
        int c;
        Node l, r;

        public int getC() {
            return c;
        }
    }
    public static <T> Node add(Node start, int data) {
        if(start == null) {
            return new Node(data);
        }
        else if(start.l != null && start.c>=data) {
            add(start.l, data);
        }
        else if(start.l == null && start.c>=data) {
            start.l = new Node(data);
        }
        else if(start.r != null && start.c<data) {
            add(start.r, data);
        }
        else if(start.r == null && start.c<data) {
            start.r = new Node(data);
        }
        return start;
    }
    public static void show(Node start) {
        if(start != null) {
            show(start.l);
            System.out.println(start.c);
            show(start.r);
        }
    }

    static void mirror(Node start) {
        if(start != null) {
            mirror(start.l);
            mirror(start.r);
            //swap
            Node tmp = start.l;
            start.l = start.r;
            start.r = tmp;
        }
    }

    static public Integer lca(Node start, int l1, int l2, int[] c) {
        if(start != null) {
            if(start.c == l1 || start.c == l2) {
                c[0]++;
                return start.c;
            }
            Integer l = lca(start.l, l1, l2, c);
            Integer r = lca(start.r, l1, l2, c);
            if(l != null && r != null) {
                return start.c;
            }
            if(l != null) {
               return l;
            }
            if(r != null) {
                return r;
            }
        }
        return null;
    }

    public static Node lca1(Node start, int l1, int l2, int[] c) {
        if(start != null) {
            if(start.c == l1 || start.c == l2) {
                c[0]++;
                return start;
            }
            Node l = lca1(start.l, l1, l2, c);
            Node r = lca1(start.r, l1, l2, c);
            if(l != null && r != null) {
                return start;
            }
            if(l != null) {
                return l;
            }
            if(r != null) {
                return r;
            }
        }
        return null;
    }

    public boolean isBST() {
        return true;
    }

    public static boolean exists(Node start, int i) {
        if(start != null) {
            return start.c == i || exists(start.l, i) || exists(start.r, i);
        }
        return false;
    }

    public static boolean isMirror(Node s1, Node s2) {
        if(s1 == null && s2 == null) {
            return true;
        }
        if(s1 == null) {
            return false;
        }
        if(s2 == null) {
            return false;
        }
        return s1.c == s2.c && isMirror(s1.l, s2.r) && isMirror(s1.r, s2.l);
    }

    public static void main(String[] args) {
        Node start = null;
        start  = add(start, 7);
        start  = add(start, 5);
        start  = add(start, 6);
        start  = add(start, 4);
        start  = add(start, 9);

        Node start1 = null;
        start1  = add(start1, 7);
        start1.r = new Node(5);
        start1.l = new Node(9);
        start1.r.l = new Node(6);
        start1.r.r = new Node(4);
        //start1.r.r.l = new Node(5);
        System.out.println(isMirror(start,start1));
        show(start);

        //LCA
        int c[] = {0};
        int lca = lca(start, 4,7, c);
        if(c[0] == 2) {
            System.out.println("lca " +lca);
        }

        //LCA
        System.out.println("new lca");
        int d[] = {0};
        Node node = lca1(start, 4,7, d);
        if(node == null) {
            System.out.println("Both elements dont exist in BST");
        }
        else if(d[0] == 2) {
            System.out.println(node.c);
        }
        else if(d[0] == 1) {
            if((node.c == 4 && exists(node, 7))|| (node.c == 7 && exists(node, 4))) {
                System.out.println(node.c);
            }
        }
        mirror(start);

        show(start);
    }
}
