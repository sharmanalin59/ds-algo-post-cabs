/**
 * @author nalin.sharma on 25/09/21
 */
public class Triplet {
    static class Node {
        int i;
        int lCnt = 0, rCnt = 0;
        Node l,r;

        public Node(int i) {
            this.i = i;
        }
    }

    static Node add(Node start, int i) {
        if(start == null) {
            start = new Node(i);
        }
        else if(start.i < i && start.r != null) {
            start.rCnt++;
            add(start.r, i);
        }
        else if(start.i < i && start.r == null) {
            start.rCnt++;
            start.r = new Node(i);
        }

        else if(start.i > i && start.l != null) {
            start.lCnt++;
            add(start.l, i);
        }
        else if(start.i > i && start.l == null) {
            start.lCnt++;
            start.l = new Node(i);
        }
        return start;
    }

    static void show(Node start) {
        if(start != null) {
            show(start.l);
            System.out.print(start.i+" "+start.lCnt+" "+start.rCnt);
            show(start.r);
        }
    }

    static void countTriplet(Node start, int item, int cnt []) {
        Node found = find(start, item);
        if(found != null) {
            //findGr(found);
        }
    }

    private static Node find(Node start, int item) {
        if(start != null) {
            if(start.i == item) {
                return start;
            }
            Node l = find(start.l, item);
            Node r = find(start.r, item);
            if(l != null) {
                return l;
            }
            return r;
        }
        return null;
    }

    /**
     * 3 5 4 7 8 3 4 6
     * @param args
     */
    public static void main(String[] args) {
        Node start = null;
        start = add(start, 3);
        start = add(start, 5);
        start = add(start, 4);
        start = add(start, 7);
        start = add(start, 8);
        start = add(start, 3);
        start = add(start, 4);
        start = add(start, 6);
        show(start);

        int arr[] = {3, 5, 4, 7, 8, 3, 4, 6};

        int out = 0;
        int cnt [] = {0,0};
        for(int i : arr) {
            cnt = new int[2];
            countTriplet(start, i, cnt);
        }
    }

}
