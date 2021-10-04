/**
 * @author nalin.sharma on 19/08/21
 *
 * 1 2 1 3 4 - O(N)
 * LRU - Map<Int, List<Node>> O(1)
 *
 * stack
 * 1 2 3 4 5
 * Q -         Q
 * 5           4 3 2 1
 *
 * rec (q, int item) {
 *  int poped = remove();
 *  rec(q,item);
 *  if(q.isempty) {
 *      q.add(item);
 *  }
 *  q.add(poped);
 * }
 */
public class LLRemoveElement {

    static class LL {
        static class Node {
            Node(int m) {
                n = m;
            }
            int n;
            Node nxt;
        }
        Node start, end;
        void add(int i) {
            if(start == null && end == null) {
                start = end = new Node(i);
            }
            else {
                end.nxt = new Node(i);
                end = end.nxt;
            }
        }
        void delete(int i) {
            if(start == null && end == null) {
                return;
            }
           Node tmp = start, old = null;
           while(tmp != null) {
               if(tmp.n == i) {
                   if(tmp == start) {
                       if(end != start) {
                           start = start.nxt;
                           tmp = start;
                           old = null;
                           continue;
                       }
                       else {
                           start = end = null;
                           break;
                       }
                   }
                   else {
                       old.nxt = tmp.nxt;
                       tmp = old.nxt;
                       continue;
                   }
               }
               old = tmp;
               tmp = tmp.nxt;
           }
        }
        void show() {
            Node tmp = start;
            System.out.println();
            while(tmp != null) {
                System.out.print(tmp.n+" ");
                tmp = tmp.nxt;
            }
        }
    }

    public static void main(String[] args) {
        LL l = new LL();
        l.add(1);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(1);
        l.add(4);
        l.add(1);
        l.show();
        l.delete(4);
        l.show();
        //l.delete(4);
        //l.show();
    }
}
