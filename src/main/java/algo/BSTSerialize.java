package algo;

public class BSTSerialize {
    static class Node {
        int d;
        Node l,r;
        Node(int j) {
            d = j;
        }
    }
    static Node add(Node start, int i) {
        if(start == null) {
            start = new Node(i);
        }
        else if(start.l != null && i <= start.d) {
            add(start.l,i);
        }
        else if(start.l == null && i <= start.d) {
            start.l = new Node(i);
        }
        else if(start.r != null && i > start.d) {
            add(start.r,i);
        }
        else if(start.r == null && i > start.d) {
            start.r = new Node(i);
        }
        return start;
    }

    static void show(Node start) {
        if(start != null){
            show(start.l);
            System.out.println(start.d);
            show(start.r);
        }
    }

    static void se(Node start, String [] s) {
        if (start != null) {
            s[0] += start.d;
            se(start.l, s);
            se(start.r, s);
        }
        else {
            s[0] += "#";
        }
    }

    static Node de(Node start, String s, int ind[]) {
        if (ind[0] < s.length() && s.charAt(ind[0]) != '#') {
            start = new Node(s.charAt(ind[0]++));
            start.l = de(start.l, s, ind);
            start.r = de(start.r, s, ind);
        }
        return start;
    }

    public static void main(String[] args) {
        Node start = null;
        start = add(start, 6);
        start = add(start, 4);
        start = add(start, 5);
        start = add(start, 1);
        start = add(start, 2);
        start = add(start, 3);
        show(start);
        String [] s = {""};
        se(start, s);
        System.out.println(s[0]);

        int ind [] = {0};
        Node de = de(null, s[0], ind);
        show(start);
    }
}
