/**
 * @author nalin.sharma on 18/10/21
 */
public class IntersectionLL {
    static class Node {
        int i;
        Node nxt;

        public Node(int i) {
            this.i = i;
        }
    }

    static Node intersect(Node s1, Node s2) {
        if(s1 == null || s2 == null) {
            return null;
        }
        if(s1 == s2) {
            return s1;
        }
        Node t1 = s1, t2 = s2;
        while(t1 != t2) {
            t1 = t1.nxt;
            t2 = t2.nxt;
            if(t1 == null) {
                t1 = s2;
            }
            if(t2 == null) {
                t2 = s1;
            }
            if(t1 == t2) {
                return t1;
            }
        }
        return null;
    }

    static void show(Node s) {
        while(s != null) {
            System.out.print(s.i+" ");
            s = s.nxt;
        }
    }
    public static void main(String[] args) {
        Node start = new Node(1);
        start.nxt = new Node(5);
        start.nxt.nxt = new Node(4);

        Node start1 = new Node(8);
        start1.nxt = new Node(7);
        start1.nxt.nxt = start.nxt.nxt;

        start.nxt.nxt.nxt = new Node(3);
        start.nxt.nxt.nxt.nxt = new Node(2);
        start.nxt.nxt.nxt.nxt.nxt = new Node(1);

        System.out.println("l1");
        show(start);
        System.out.println("\nl2");
        show(start1);
        Node meet = intersect(start, start1);
        if(meet == null)
        System.out.println("no point");
        else
            System.out.println("point "+meet.i);
    }
}
