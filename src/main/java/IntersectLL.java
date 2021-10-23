/**
 * @author nalin.sharma on 20/10/21
 */
public class IntersectLL {
    static class Node {
        int i;
        Node nxt;

        public Node(int i) {
            this.i = i;
        }
    }

    static void show(Node start) {
        System.out.println("show..");
        while(start != null) {
            System.out.print(start.i+" ");
        start = start.nxt;
        }
    }

    static Node intersect(Node s1, Node s2) {
        if(s1 == null || s2 == null) {
            return null;
        }
        Node tmp1 = s1, tmp2 = s2;
        while(tmp1 != tmp2) {

            tmp1 = tmp1.nxt;
            tmp2 = tmp2.nxt;

            if(tmp1 == null) {
                tmp1 = s2;
            }
            if(tmp2 == null) {
                tmp2 = s1;
            }
            if(tmp1 == tmp2) {
                return tmp1;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Node s1 = new Node(1);;
        s1.nxt = new Node(4);

        Node s2 = new Node(10);

        s2.nxt = new Node(5);
        s2.nxt.nxt = new Node(8);
        s2.nxt.nxt.nxt = new Node(6);

        s1.nxt.nxt = new Node(5);
        s1.nxt.nxt.nxt = new Node(3);
        s1.nxt.nxt.nxt.nxt = new Node(2);
        s1.nxt.nxt.nxt.nxt.nxt = new Node(7);

        s2.nxt.nxt.nxt.nxt = s1.nxt.nxt;
        show(s1);
        show(s2);
        Node meetPoint = intersect(s1,s2);
        if(meetPoint != null)
        System.out.println("\n meet point at "+meetPoint.i);
        else
            System.out.println("dont meet");
    }
}
