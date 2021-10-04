package dp;

/**
 * @author nalin.sharma on 13/09/21
 */
public class Trie {
    static class Node {
        public Node(char c) {
            this.c = c;
        }

        char c;
        Node l, m, r;
        boolean ends;
    }

    static Node add(Node start, String s, int i) {
        if(start == null) {
            start = new Node(s.charAt(i));
        }
        if(start.c > s.charAt(i)) {
            start.l = add(start.l, s, i);
        }
        else if(start.c < s.charAt(i)) {
            start.r = add(start.r, s, i);
        }
        else {
            //equal
            if(i == s.length() - 1) {
                start.ends = true;
            }
            else if(i < s.length() - 1) {
                start.m = add(start.m , s, i+1);
            }
        }
        return start;
    }

    static void show(Node start, String o) {
        if(start != null) {
            if(start.ends) {
                System.out.println(o+start.c);
            }
            show(start.m, o+start.c);
            show(start.l, o);
            show(start.r, o);
        }
    }

    public static void main(String[] args) {
        Node start = null;
        start = add(start, "nalin", 0);
        start = add(start, "nipun", 0);
        show(start, "");
    }
}
