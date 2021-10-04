package algo;

import java.util.HashMap;
import java.util.Map;

public class LinkedList {
    static class List<T> {
        Node<T> start, end;
        static class Node<T> {
            T t;
            Node<T> next, pre;
            Node(T t) {
                this.t = t;
            }
        }
        Node<T> addFront(T t) {
            if(start == null) {
                return start = end = new Node<>(t);
            }
            else {
                Node<T> n = new Node<>(t);
                n.next = start;
                start.pre = n;
                start = n;
                return n;
            }
        }

        void removeLast() {
            if(start == end) {
                start = end = null;
            }
            else if(null == end){
                System.out.println("list is empty");
            }
            else if (null != end) {
                Node<T> pre = end.pre;
                pre.next = null;
                end = pre;
            }
        }

        void remove(Node<T> t) {
            if(start == t) {
                if(start == end) {
                    start = end = null;
                    System.out.println("list is empty");
                }
                else {
                    start = start.next;
                    start.pre = null;
                }
            }
            else if (t == end) {
                removeLast();
            }
            else {
                Node<T> pre = t.pre;
                Node<T> nxt = t.next;
                pre.next = nxt;
                nxt.pre = pre;
            }
        }
        void show() {
            List.Node<T> n = start;
            System.out.println();
            while(n != null) {
                System.out.print(" " +n.t);
                n = n.next;
            }
        }
    }

    static class Cache<T> {
        Cache(int s) {
            size = s;
        }
        int size;
        List<T> list = new List<>();
        Map<T, List.Node<T>> map = new HashMap();
        void add(T t) {
            if(map.containsKey(t)) {
                List.Node<T> n = map.get(t);
                list.remove(n);
                map.put(t, list.addFront(n.t));
            }
            else {
                if (map.size() < size) {
                    List.Node<T> n = list.addFront(t);
                    map.put(t, n);
                } else if (map.size() == size) {
                    list.removeLast();
                    List.Node<T> n = list.addFront(t);
                    map.put(t,n);
                }
            }
        }
        void show() {
            list.show();
        }
    }

    public static void main(String[] args) {
        Cache<Integer> c = new Cache<>(3);
        c.add(1);
        c.add(2);
        c.show();
        c.add(1);
        c.show();
        c.add(3);
        c.show();
        c.add(2);
        c.add(1);
        c.show();
        c.add(4);
        c.show();
    }
}
