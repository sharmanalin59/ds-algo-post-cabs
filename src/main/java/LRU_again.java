import java.util.HashMap;
import java.util.Map;

/**
 * @author nalin.sharma on 21/10/21
 */
public class LRU_again {
    static class LRU {
        LRU(int s) {
            l = new LL();
            map = new HashMap<>();
            size = s;
        }
        LL l;
        int size;
        Map<Integer, LL.Node> map;
        void add(int i) {
            if(map.containsKey(i)) {
                System.out.println("cache hit..");
                LL.Node node = map.get(i);
                l.remove(node);
                LL.Node added = l.addFront(i);
                map.put(i, added);
            }
            else {
                System.out.println("cache miss..");
                if(map.size() == size) {
                    LL.Node rem = l.removeEnd();
                    map.remove(rem.i);
                }
                LL.Node added = l.addFront(i);
                map.put(i, added);
            }
            l.show();
        }
    static class LL {
        static class Node {
            public Node(int i) {
                this.i = i;
            }

            int i;
            Node nxt, pre;
        }

        Node start, end;
        void show() {
            System.out.println();
            Node tmp = start;
            while(tmp != null) {
                System.out.print(tmp.i+" ");
                tmp = tmp.nxt;
            }
            System.out.println();
        }
        Node addFront(int i) {
            if (start == null && end == null) {
                return start = end = new Node(i);
            } else {
                start.pre = new Node(i);
                start.pre.nxt = start;
                start = start.pre;
                return start;
            }
        }

        Node removeEnd() {
            if (start == end) {
                return start = end = null;
            } else {
                Node old = end.pre, rem = end;
                old.nxt = null;
                rem.pre = null;
                end = old;
                return rem;
            }
        }

        void remove(Node del) {
            if (del != null && start != null) {
                if (del == start && del == end) {
                    start = end = null;
                    return;
                } else if (del == start) {
                    start.nxt.pre = null;
                    start = start.nxt;
                    return;
                } else if (del == end) {
                    Node old = end.pre;
                    old.nxt = null;
                    end.pre = null;
                    end = old;
                    return;
                } else {
                    del.pre.nxt = del.nxt;
                    del.nxt.pre = del.pre;
                }
            }
        }
    }
    }
    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(2);
    }
}
