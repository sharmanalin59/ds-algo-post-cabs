/**
 * @author nalin.sharma on 20/10/21
 */
public class LCA_BinarTree {
    static class Node {
        int i;
        Node l,r;

        public Node(int i) {
            this.i = i;
        }
    }

    static Node lca(Node start, int i1, int i2) {
        if(start != null) {
            if(start.i == i1 || start.i == i2) {
                return start;
            }
            Node l = lca(start.l, i1, i2);
            Node r = lca(start.r, i1, i2);

            return (l != null && r != null) ? start : (l != null) ? l : r;

        }
        return null;
    }
    public static void main(String[] args) {
        Node start = new Node(50);
        start.l = new Node(90);
        start.l.l = new Node(30);
        start.l.l.l = new Node(20);
        start.l.l.r = new Node(35);
        start.l.r = new Node(120);


        start.r = new Node(60);
        start.r.l = new Node(80);
        start.r.r = new Node(100);

        Node lca = lca(start, 20, 120);
        System.out.println(lca.i);
        lca = lca(start, 20, 80);
        System.out.println(lca.i);

        lca = lca(start, 30, 35);
        System.out.println(lca.i);

    }
}
