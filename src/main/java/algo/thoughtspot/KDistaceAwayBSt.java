package algo.thoughtspot;

public class KDistaceAwayBSt {
    private static class Node {
        Node(int d) {
            i = d;
        }
        int i;
        Node l,r;
    }

    static int find(Node start, int item, int k) {
        if(start != null) {
            if(start.i == item) {
                kAwayFromItem(start,0, k);
                return 0;
            }
            int l = find(start.l, item, k);
            int r = find(start.r, item, k);
            if(l!= -1) {
                if(l + 1 == k) {
                    System.out.println(start.i);
                }
                else if(l < k) {

                    kAwayFromItem(start.r,l+2, k);
                }
                return l + 1;
            }
            if(r!= -1) {
                if(r + 1 == k) {
                    System.out.println(start.i);
                }
                else if(r < k) {
                    kAwayFromItem(start.l,r+2, k);
                }
                return r + 1;
            }
        }
        return -1;
    }

    static void kAwayFromItem(Node start, int ind, int k) {
        //find the item and its parents
        if(start != null) {
            if(ind == k) {
                System.out.println(start.i);
            }
            if(ind < k) {
                kAwayFromItem(start.l, ind + 1, k);
                kAwayFromItem(start.r, ind + 1, k);
            }
        }
    }
    public static void main(String[] args) {
        Node start = new Node(20);
        start.l = new Node(8);
        start.r = new Node(22);
        start.l.l = new Node(4);
        start.l.r = new Node(12);
        start.l.r.l = new Node(10);
        start.l.r.r = new Node(14);

        find(start, 14, 4);
    }
}
