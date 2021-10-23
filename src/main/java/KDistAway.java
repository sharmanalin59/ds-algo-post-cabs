/**
 * @author nalin.sharma on 11/10/21
 */
public class KDistAway {
    static class Node {
        int i;
        Node l,r;

        public Node(int i) {
            this.i = i;
        }
    }

    static void down(Node start, int l, int k) {
        if(start != null && l <= k) {
            if( l == k)
            System.out.println(start.i);
            down(start.l, l+1, k);
            down(start.r, l+1, k);
        }
    }
    static int find(Node start, Node target, int k) {
        if(start != null) {
            if(start.i == target.i) {
                down(start, 0, k);
                return 1;
            }
            int l = find(start.l, target, k);
            if(l != -1) {
                if(l == k) {
                    System.out.println(start.i);
                }
                else {
                   down(start.r, l+1, k);
                }
                return l+1;
            }
            int r = find(start.r, target, k);
            if(r != -1) {
                if(r == k) {
                    System.out.println(start.i);
                }
                else {
                    down(start.l, r+1, k);
                }
                return r+1;
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        Node start = new Node(20);
        start.l = new Node(8);
        start.r = new Node(22);
        start.l.l = new Node(4);
        start.l.r = new Node(12);
        start.l.r.l = new Node(10);
        start.l.r.r = new Node(14);

        find(start, start.l.r, 1);
    }
}
