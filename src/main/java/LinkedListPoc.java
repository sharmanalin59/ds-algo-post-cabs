import java.util.Objects;

/**
 * @author nalin.sharma on 12/10/21
 */
public class LinkedListPoc {
    static class Node {
        int i;

        public Node(int i) {
            this.i = i;
        }
        Node nxt;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return i == node.i &&
                    Objects.equals(nxt, node.nxt);
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, nxt);
        }
    }
    static void show(Node start) {
        System.out.println();
         while(start != null) {
             System.out.print(start.i+" ");
            start = start.nxt;
        }
    }
    static Node divide(Node start) {
        Node mid = findMid(start);
        Node head2 = mid.nxt;
        mid.nxt = null;
        if(head2 == null) {
            return start;
        }
        Node nHead1 = divide(start);
        Node nHead2 = divide(head2);

        return merge(nHead1, nHead2);
    }

    private static Node merge(Node nHead1, Node nHead2) {
        if(nHead1 == null) {
            return nHead2;
        }
        if(nHead2 == null) {
            return nHead1;
        }
        Node tmp = new Node(-1);
        Node start = tmp;
        while(nHead1 != null && nHead2 != null) {
            if(nHead1.i <= nHead2.i) {
                tmp.nxt = nHead1;
                nHead1 = nHead1.nxt;
            }
            else {
                tmp.nxt = nHead2;
                nHead2 = nHead2.nxt;
            }
            tmp = tmp.nxt;
        }
        while(nHead1 != null) {
            tmp.nxt = nHead1;
            nHead1 = nHead1.nxt;
            tmp = tmp.nxt;
        }
        while(nHead2 != null) {
            tmp.nxt = nHead2;
            nHead2 = nHead2.nxt;
            tmp = tmp.nxt;
        }
        return start.nxt;
    }

    private static Node findMid(Node start) {
        if(start == null) {
            return start;
        }
        Node first = start, sec = first;
        while(true) {
            if(sec.nxt == null || sec.nxt.nxt == null) {
                return first;
            }
            first = first.nxt;
            sec = sec.nxt.nxt;
        }
    }

    static Node removeAllDupInSortedLL(Node start) {
        Node dummy = new Node(-1);
        dummy.nxt = start;
        Node old = dummy, cur = start;
        while(cur != null) {
            while(cur.nxt != null && old.nxt.i == cur.nxt.i) {
                cur = cur.nxt;
            }
            if(old.nxt != cur) {
                old.nxt = cur.nxt;
            }
            else {
                old = cur;
            }
            cur = cur.nxt;
        }
        return dummy.nxt;
    }
    static void removeDupInSortedLL(Node start) {
        Node tmp;
        while(start != null) {
            tmp = start;
            while(tmp.nxt != null && tmp.nxt.i == start.i) {
                tmp = tmp.nxt;
            }
            start.nxt = tmp.nxt;
            start = start.nxt;
        }
    }
    public static void main(String[] args) {
        Node start = new Node(1);
        start.nxt = new Node(4);
        start.nxt.nxt = new Node(3);
        start.nxt.nxt.nxt = new Node(3);
        show(start);
        start = divide(start);
        show(start);
        //start = removeAllDupInSortedLL(start);
        removeDupInSortedLL(start);
        show(start);

        /*start.nxt.nxt.nxt = start;
        start.hashCode();*/
    }
}
