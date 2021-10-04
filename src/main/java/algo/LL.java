package algo;

import java.lang.reflect.Array;

public class LL<T> {
        Node<T> start, end;
        int size;
        public static class Node<T> {
            Node(T t) {
                this.t = t;
            }
            T t;
            Node<T> nxt;
        }

        public void addEnd(T t) {
        if(start == end && end == null) {
            start = end = new Node<>(t);
        }
        else {
            end.nxt = new Node<>(t);
            end = end.nxt;
        }
            size++;
    }
        public void show() {
        Node<T> tmp = start;
        while(tmp != null) {
            System.out.print(" "+tmp.t);
            tmp = tmp.nxt;
        }
    }

    public T[] arr() {
        Node<T> tmp = start;
        T t;
        final T[] a = (T[]) new Object[size];
        int i = 0;
        while(tmp != null) {
            a[i++] = tmp.t;
            tmp = tmp.nxt;
        }
        return a;
    }

        public void rev(int k) {
        start = rev(start, k);
    }
        private Node<T> rev(Node<T> start, int k) {
        if(start == null) {
            return null;
        }
        Node<T> p = null,q = start,r, old = q;
        int i = 1;
        while (q != null && i <= k) {
            r = q.nxt;
            q.nxt = p;
            p = q;
            q = r;
            i++;
        }
        old.nxt = rev(q, k);
        return p;
    }
}
