/**
 * @author nalin.sharma on 27/09/21
 */
public class FoldLL {
    static class Node {
        int i;
        Node nxt;

        public Node(int i) {
            this.i = i;
        }
    }

    static Node add(Node start, int i) {
        if(start == null) {
            start = new Node(i);
        }
        else {
            Node tmp = start;
            while(tmp.nxt != null) {
                tmp = tmp.nxt;
            }
            tmp.nxt = new Node(i);
        }
        return start;
    }

    static void show(Node start) {
        System.out.println();
        Node tmp = start;
        while(tmp != null) {
            System.out.print(tmp.i+" ");
            tmp = tmp.nxt;
        }
    }
/*

    static void fold(Node[] startArr, Node end, int[] s) {
        if(end == null) {
            return;
        }
        fold(startArr, end.nxt, s);
        if(s[0] == ) {
            return;
        }
        end.i += startArr[0].i;
        startArr[0] = startArr[0].nxt;
    }
*/

    public static void main(String[] args) {
        Node start = null;
        start = add(start, 1);
        start = add(start, 2);
        start = add(start, 3);
        start = add(start, 4);
        start = add(start, 5);
        show(start);

        /*int size = 5;
        Node[] startArr = {start};
        int mid = size / 5;
        int[] midArr = {mid};
        fold(startArr, start, midArr);
        show(start);
        *//*Node revStart = reverse(start);
        show(revStart);

        Node tmp = revStart;
        System.out.println();*//*
        Node tmp = start;
        for(int i = 0; i <= mid; i++) {
            System.out.print(tmp.i+" ");
            tmp = tmp.nxt;
        }*/


    }

    private static Node reverse(Node start) {
        Node p = null, q = start, r;
        while(q != null) {
            r = q.nxt;
            q.nxt = p;
            p = q;
            q = r;
        }
        return p;
    }
}
