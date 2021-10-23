/**
 * @author nalin.sharma on 06/10/21
 */
public class MergeSortLinkedList {
    static class Node {
        public Node(int i) {
            this.i = i;
        }

        int i;
        Node nxt;
    }
    static void show(Node start) {
        System.out.println();
        while(start != null) {
            System.out.print(start.i+" ");
            start = start.nxt;
        }
    }

    static Node divide(Node start) {
        Node mid = find(start);

        Node head = mid.nxt;
        if(head == null) {
            return start;
        }
        mid.nxt = null;
        Node n1 = divide(start);
        Node n2 = divide(head);

        return merge(n1,n2);
    }

    private static Node merge(Node start, Node head) {
        Node tmp, nStart;
        //base condition
        if(start == null) {
            return head;
        }
        if(head == null) {
            return start;
        }
        //new start
        if(start.i <= head.i) {
            nStart = tmp = start;
            start = start.nxt;
        }
        else {
            nStart = tmp = head;
            head = head.nxt;
        }
        //merge
        while(start != null && head != null) {
            if(start.i <= head.i) {
                tmp.nxt = start;
                start = start.nxt;
                tmp = tmp.nxt;
            }
            else {
                tmp.nxt = head;
                head = head.nxt;
                tmp = tmp.nxt;
            }
        }
        while(start != null) {
            tmp.nxt = start;
            start = start.nxt;
            tmp = tmp.nxt;
        }
        while(head != null) {
            tmp.nxt = head;
            head = head.nxt;
            tmp = tmp.nxt;
        }
        return nStart;
    }

    private static Node find(Node start) {
        Node one = start, two = start.nxt;
        while(one != null && two != null) {
            if(one.nxt == null)
                return one;
            one = one.nxt;
            if(two.nxt == null || two.nxt.nxt == null)
                return one;
            two = two.nxt.nxt;
        }
        return one;
    }

    public static void main(String[] args) {
        Node start = new Node(2);
        start.nxt = new Node(3);
        start.nxt.nxt = new Node(1);
        start.nxt.nxt.nxt = new Node(4);
        show(start);
        Node nStart = divide(start);
        show(nStart);
    }
}
