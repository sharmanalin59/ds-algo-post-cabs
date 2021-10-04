package tree;

import java.util.*;

/**
 * @author nalin.sharma on 23/06/21
 */
public class BST {
    static class Node {
        Node(int m) {
            n = m;
        }
        int n;
        Node l,r;
    }
    static Node add(Node start, int item) {
        if(start == null) {
            start = new Node(item);
        }
        else if(start.l == null && start.n >= item) {
            start.l = new Node(item);
        }
        else if(start.l != null && start.n >= item) {
            add(start.l, item);
        }
        else if(start.r == null && start.n < item) {
            start.r = new Node(item);
        }
        else if(start.r != null && start.n < item) {
            add(start.r, item);
        }
        return start;
    }

    static void show(Node start) {
        if(start!=null) {
            show(start.l);
            System.out.print(start.n+" ");
            show(start.r);
        }
    }

    /*
             10
          7     20
            9
           8 10

     */
    static boolean isBST(Node start, int l, int r) {
        if(start == null) {
            return true;
        }
        return (start.n <= r && start.n > l)
                && isBST(start.l, l, start.n)
                && isBST(start.r, start.n, r);
    }

    private static Node lca(Node start, int a, int b) {
        if(start != null) {
            if(start.n == a || start.n == b) {
                return start;
            }
            Node ln = lca(start.l, a, b);
            Node rn = lca(start.r, a, b);
            if(ln != null && rn != null) {
                return start;
            }
            return (ln == null) ? rn : ln;
        }
        return null;
    }

    static int lcaBST(Node start, int a, int b) {
        Node out = lca(start, a, b);
        if(out == null) {
            return -1;
        }
        if(out.n != a && out.n != b) {
           return out.n;
        }
        if(out.n == a) {
            if(find(out.l, b) || find(out.r, b)) {
                return out.n;
            }
            return -1;
        }
        if(out.n == b) {
            if(find(out.l, a) || find(out.r, a)) {
                return out.n;
            }
            return -1;
        }
        return -1;
    }

    private static boolean find(Node out, int a) {
        if(out != null) {
            if(out.n == a) {
              return true;
            }
            return find(out.l, a) || find(out.r, a);
        }
        return false;
    }

    static void rightV(Node start, int level, int [] arr) {
        if(start != null) {
            if(level == arr[0]) {
                System.out.print(start.n+" ");
                arr[0]++;
            }
            rightV(start.r, level + 1, arr);
            rightV(start.l, level + 1, arr);
        }
    }

    static void seralize(Node start, String [] str) {
        if(start != null) {
            str[0] += start.n;
            str[0] += ",";
            seralize(start.l, str);
            seralize(start.r, str);
        }
        else {
            str[0] += "#,";
        }
    }

    static Node deserialize(Node start, String [] s, int[] ind) {
        if(start == null) {
            if(ind[0] < s.length && !s[ind[0]].equals("#")) {
                start = new Node(Integer.parseInt(s[ind[0]]));
                ind[0]++;
                start.l = deserialize(start.l, s, ind);
                start.r = deserialize(start.r, s, ind);
                return start;
            }
            ind[0]++;
        }
        return null;
    }

    static class Wrapper {
        Wrapper(int h, int v) {
            ht = h;
            val = v;
        }
        int ht, val;
    }
    static void bottomV(Node start, int lvl, int ht, Map<Integer, Wrapper> map) {
        if(start != null) {

            if(!map.containsKey(lvl) || map.get(lvl).ht < ht) {
                map.put(lvl, new Wrapper(ht, start.n));
            }
            bottomV(start.l, lvl - 1, ht + 1, map);
            bottomV(start.r, lvl + 1, ht + 1, map);
        }
    }
    //top view, trie, desearalize, dp l pandromic
    public static void main(String[] args) {
        Node start = null;
        start = add(start, 20);
        start = add(start, 22);
        start = add(start, 8);
        start = add(start, 4);
        start = add(start, 12);
        //start = add(start, 12);
        start = add(start, 10);
        start = add(start, 14);
        show(start);
        System.out.println("lca : "+lcaBST(start, 14, 4));
        System.out.println("is bst : "+ isBST(start, Integer.MIN_VALUE, Integer.MAX_VALUE));

        String str [] = {""};
        seralize(start, str);
        str[0] = str[0].substring(0, str[0].length() - 1);
        System.out.println("seralized : "+str[0]);

        Node dStart = null;
        int ind [] = {0};
        System.out.println("deserilazed : ");
        dStart = deserialize(dStart, str[0].split(","), ind);
        show(dStart);

        int arr [] = {0};
        System.out.println("right v :");
        rightV(start, 0, arr);
        Map<Integer, Wrapper> map = new HashMap<>();
        System.out.println("bottom v :");
        bottomV(start, 0,0, map);
        map.forEach((k,v)-> System.out.println(v.val));
    }
}
