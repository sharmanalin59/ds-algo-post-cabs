/**
 * @author nalin.sharma on 24/09/21
 */
public class LoopLinkedList {
    static class Node {
        int i;
        Node nxt;

        public Node(int i) {
            this.i = i;
        }
    }
    static void show(Node n) {
        while(n != null) {
            System.out.print(n.i+" ");
            n = n.nxt;
        }
    }
    public static void main(String[] args) {
        Node start = new Node(1);
        start.nxt = new Node(2);
        start.nxt.nxt = new Node(3);
        start.nxt.nxt.nxt = new Node(4);
        start.nxt.nxt.nxt.nxt = new Node(5);
        start.nxt.nxt.nxt.nxt.nxt = new Node(6);
        start.nxt.nxt.nxt.nxt.nxt.nxt = new Node(7);
        start.nxt.nxt.nxt.nxt.nxt.nxt.nxt = new Node(8);

        //start.nxt.nxt.nxt.nxt.nxt.nxt.nxt.nxt = start.nxt.nxt.nxt;

        //show(start);

        Node junction = meetPoint(start, start);
        if(junction != null) {
            System.out.println(junction.i);
            System.out.println("loop at : "+loopAt(start, junction).i);
        }
        else {
            System.out.println("no loop");
        }
    }

    private static Node loopAt(Node start, Node junction) {
        while(start != junction) {
            start = start.nxt;
            junction = junction.nxt;
        }
        return start;
    }

    private static Node meetPoint(Node x, Node twoX) {
        do{
            if(x.nxt == null)
                return null;
            x = x.nxt;
            if(twoX.nxt == null || twoX.nxt.nxt == null)
                return null;
            twoX = twoX.nxt.nxt;
        }
        while(x != twoX);
        return x;
    }
}
