/**
 * @author nalin.sharma on 07/10/21
 */
public class RemoveDupLL {
    static class Node {
        public Node(int i) {
            this.i = i;
        }
        int i;
        Node nxt;
    }
    static void show(Node start) {
        while(start != null) {
            System.out.print(start.i+" ");
            start = start.nxt;
        }
    }
    static Node delAllDupInSortedList(Node start) {
        Node dummy = new Node(0);
        dummy.nxt = start;
        start = dummy;
        Node pre = dummy, cur = start;

        while(cur != null) {
            while (cur.nxt != null && cur.nxt.i == pre.nxt.i) {
                cur = cur.nxt;
            }
            if(pre.nxt == cur) {
                pre = cur;
            }
            else {
                pre.nxt = cur.nxt;
            }
            cur = cur.nxt;
        }
        return dummy.nxt;
    }

    static Node revK(Node start, int k) {
        if(start == null) {
            return null;
        }
        Node p = null, q = start, r;
        int i = 0;
        while(i < k && q != null) {
            r = q.nxt;
            q.nxt = p;
            p = q;
            q = r;
            i++;
        }
        start.nxt = revK(q, k);
        return p;
    }

    static void delDupInSortedList(Node start) {
        Node tmp = start, tmpNxt;
        while(tmp != null) {
            tmpNxt = tmp;
            while(tmpNxt.nxt != null && tmpNxt.nxt.i == tmp.i) {
                tmpNxt = tmpNxt.nxt;
            }
            if(tmp != tmpNxt) {
                tmp.nxt = tmpNxt.nxt;
            }
            tmp = tmp.nxt;
        }
    }

    public static void main(String[] args) {
        Node start = new Node(1);
        start.nxt = new Node(1);
        start.nxt.nxt = new Node(1);
        start.nxt.nxt.nxt = new Node(1);
        Node removedStart = delAllDupInSortedList(start);
        show(removedStart);


        System.out.println("dulplicate removed from sorted list");
        Node start1 = new Node(1);
        start1.nxt = new Node(1);
        start1.nxt.nxt = new Node(2);
        start1.nxt.nxt.nxt = new Node(2);
        start1.nxt.nxt.nxt.nxt = new Node(4);
        delDupInSortedList(start1);
        show(start1);


        System.out.println("\nreverse k ele");
        Node start2 = new Node(1);
        start2.nxt = new Node(2);
        start2.nxt.nxt = new Node(3);
        start2.nxt.nxt.nxt = new Node(4);
        start2.nxt.nxt.nxt.nxt = new Node(5);
        start2 = revK(start2, 2);
        show(start2);
    }
}
