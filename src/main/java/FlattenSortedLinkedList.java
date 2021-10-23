/**
 * @author nalin.sharma on 17/10/21
 */
public class FlattenSortedLinkedList {
    static class Node {
        int i;
        Node nxt, down;

        public Node(int i) {
            this.i = i;
        }
    }

    static void show(Node start) {
        System.out.println("\n show... \n");
        Node tmp;
        while(start != null) {
            tmp = start;
            System.out.println(" next ");
            while(tmp != null) {
                System.out.print(tmp.i+" ");
                tmp = tmp.down;
            }
            start = start.nxt;
        }
    }
    public static void main(String[] args) {
        Node start = new Node(5);
        start.down = new Node(7);
        start.down.down = new Node(8);
        start.down.down.down = new Node(30);

        start.nxt = new Node(10);
        start.nxt.down = new Node(20);

        start.nxt.nxt = new Node(19);
        start.nxt.nxt.down = new Node(22);
        start.nxt.nxt.down.down = new Node(50);

        start.nxt.nxt.nxt = new Node(28);
        start.nxt.nxt.nxt.down = new Node(35);
        start.nxt.nxt.nxt.down.down = new Node(40);
        start.nxt.nxt.nxt.down.down.down = new Node(45);
        show(start);
        flatten(start);
        show(start);

    }
    static Node flatten(Node start) {
        Node merged = null, old;
        while(start != null) {
            old = start;
            merged = merge(merged, start);
            start = start.nxt;
            old.nxt = null;
        }
        return merged;
    }
    static Node merge(Node s1, Node s2) {
        if(s1 == null) {
            return s2;
        }
        if(s2 == null) {
            return s1;
        }
        Node dummy = new Node(0);
        Node start = dummy;
        while(s1 != null && s2 != null) {
            if(s1.i <= s2.i) {
                dummy.down = s1;
                s1 = s1.down;
                dummy = dummy.down;
            }
            else {
                dummy.down = s2;
                s2 = s2.down;
                dummy = dummy.down;
            }
        }
        while(s1 != null) {
            dummy.down = s1;
            s1 = s1.down;
            dummy = dummy.down;
        }
        while(s2 != null) {
            dummy.down = s2;
            s2 = s2.down;
            dummy = dummy.down;
        }
        return start.down;
    }
}
