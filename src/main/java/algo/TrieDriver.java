package algo;

public class TrieDriver {
    static class Trie {
        Node start = null;

        void add(String s) {
            start = add(s, 0, start);
        }

        Node add(String s, int ind, Node next) {
            if (next == null) {
                next = new Node(s.charAt(ind));
            }
            if (s.charAt(ind) < next.c) {
                //left
                next.l = add(s, ind, next.l);
            }
           else if (s.charAt(ind) > next.c) {
                //left
                next.r = add(s, ind, next.r);
            } else {
                if (ind < s.length() - 1) {
                    next.m = add(s, ind + 1, next.m);
                } else {
                    next.ends = true;
                }
            }
            return next;
        }

        void show() {
            show(start, "");
        }
        void show(Node start, String out) {
            if (start != null) {
                out += start.c;
                if (start.ends) {
                    System.out.println(out);
                }
                show(start.m, out);
                //left
                show(start.l, out.substring(0, out.length() - 1));
                //left
                show(start.r, out.substring(0, out.length() - 1));
            }
        }

        static class Node {
            Node(char d) {
                c = d;
            }

            char c;
            Node l, m, r;
            boolean ends;
        }
    }
    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("nalin");
        t.add("az");
        t.add("dz");
        t.show();
    }

}
