package algo;

import java.util.*;

/**
 * @author nalin.sharma on 25/08/21
 */
public class GrowwP1 {
    static class LL<T> {
        static class Node<T> {
            Node(T y) {
                i = y;
            }
            T i;
            Node<T> nxt;
        }
       Node<T> start;
        Node<T> end;
        Map<T, Integer> map = new HashMap<>();
        void add(T item) {
            if(start == end && start == null) {
                start = end = new Node<>(item);
            }
            else {
                end.nxt = new Node<>(item);
                end = end.nxt;
            }
        }
        void show() {
            System.out.println();
            Node<T> tmp = start;
            while(tmp != null) {
                System.out.print(tmp.i+" ");
                tmp = tmp.nxt;
            }
        }
        void removeDup() {
            Node<T> tmp = start;
            while(tmp != null) {
                if(map.containsKey(tmp.i)) {
                    map.put(tmp.i, map.get(tmp.i) + 1);
                }
                else {
                    map.put(tmp.i, 1);
                }
                tmp = tmp.nxt;
            }

            //remove logic
            Node<T> old = null;
            tmp = start;
            while(tmp != null) {
                if(map.containsKey(tmp.i) && map.get(tmp.i) > 1) {
                    if(tmp == start) {
                        if(start == end) {
                            //one ele
                            start = end = null;
                        }
                        else {
                            start = start.nxt;
                            tmp = start;
                            continue;
                        }
                    }
                    else {
                        if(tmp == end) {
                            old.nxt = null;
                            end = old;
                            break;
                        }
                        else {
                            old.nxt = tmp.nxt;
                            continue;
                        }
                    }
                }
                old = tmp;
                tmp = tmp.nxt;
            }
        }

        void removeDupLoop() {
            Node<T> tmp = start, old = null;
            while(tmp != null) {
                Node<T> inner = tmp.nxt;
                while(inner != null && inner.i == tmp.i) {
                    inner = inner.nxt;
                }
                if(inner != tmp.nxt) {
                    if(inner == null) {
                        end = old;
                    }
                    if(tmp == start) {
                        tmp = start = inner;
                        if(inner == null) {
                            end = null;
                        }
                    }
                    else {
                        old.nxt = inner;
                        tmp = inner;
                    }
                }
                else {
                    old = tmp;
                    tmp = tmp.nxt;
                }
            }
        }
        public static void main(String[] args) {
            LL<Integer> l = new LL<>();
            l.add(0);
            l.add(1);
            l.add(1);
            l.add(2);
            l.add(3);
            l.add(3);
            l.show();
            l.removeDupLoop();//removeDup();
            l.show();
        }
    }
}
