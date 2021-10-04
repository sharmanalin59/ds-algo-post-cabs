package algo.google;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nalin.sharma on 29/07/21
 */
public class Cache {
    enum CacheStrategy {
        LRU, FIFO
    }
    static abstract class CacheBase<T> {
        CacheBase(int s) {
            size = s;
        }
        int size;
        abstract void put(T t, Object o);
        abstract Object get(T t);
        abstract void clear();
        void show(){}
    }
    static class LRU<T> extends CacheBase<T> {
        LRU(int s) {
            super(s);
            map = new HashMap<>();
            list = new LinkedList<T>();
        }
        static class LinkedList<T> {
            static class Node<T> {
                Node(T y, Object c) {
                    t = y;
                    o = c;
                }
                T t;
                Object o;
                Node<T> next, pre;
            }
            Node<T> start = null, end = null;
            Node<T> addAtStart(T t, Object o) {
                if(start == null) {
                    end = start = new Node<>(t,o);
                }
                else {
                    start.pre = new Node<>(t,o);
                    start.pre.next = start;
                    start = start.pre;
                }
                return start;
            }
            void remove(Node<T> node) {
                if(start == null) {
                    return;
                }
                if(node == start && node == end) {
                    start = end = null;
                }
                else if(node == start) {
                    Node<T> nxt = start.next;
                    nxt.pre = null;
                    start.next = null;
                    start = nxt;
                }
                else if(node == end) {
                    Node<T> pre = end.pre;
                    pre.next = null;
                    end.pre = null;
                    end = pre;
                }
                else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
            }
            T removeAtEnd() {
                if(start == null) {
                    return null;
                }
                if(start == end) {
                    Node<T> old = start;
                    start = end = null;
                    return old.t;
                }
                else {
                    Node<T> old = end.pre;
                    old.next = null;
                    end.pre = null;
                    end = old;
                    return old.t;
                }
            }
        }
        LinkedList<T> list;
        Map<T, LinkedList.Node<T>> map;

        @Override
        void put(T t, Object o) {
            System.out.println("\nputting key: "+t+" value: "+ o);
            final int s = size;
            if(map.containsKey(t)) {
                LinkedList.Node<T> node = map.get(t);
                node.o = o;
                list.remove(node);
                LinkedList.Node<T> added = list.addAtStart(node.t, node.o);
                map.put(t, added);
            }
            else if(map.size() == s) {
                T removedKey = list.removeAtEnd();
                LinkedList.Node<T> added = list.addAtStart(t, o);
                map.remove(removedKey);
                map.put(t, added);
            }
            else if(map.size() < s) {
                LinkedList.Node<T> added = list.addAtStart(t, o);
                map.put(t, added);
            }
        }

        @Override
        Object get(T t) {
            if(map.containsKey(t)) {
                System.out.println("\nfound in cache with key :"+t);
                return map.get(t).o;
            }
            System.out.println("\n"+t+" cache not found in cache.. checking db");
            return null;
        }

        @Override
        void clear() {
            System.out.println("\nclearing cache");
            map.clear();
            list.start = list.end = null;
        }
        @Override
        void show(){
            LinkedList.Node<T> tmp = list.start;
            System.out.println("\ncache : []");
            while(tmp != null) {
                System.out.print("\nkey: "+tmp.t+" value: "+tmp.o);
                tmp = tmp.next;
            }
        }
    }

    static class FIFO<T> extends CacheBase<T> {
        FIFO(int s) {
            super(s);
        }

        @Override
        void put(T t, Object o) {

        }

        @Override
        Object get(T t) {
            return null;
        }

        @Override
        void clear() {

        }
    }
    static class CacheFactory<T> {
        <T> CacheBase<T> getCache(CacheStrategy cacheStrategy, int s) {
            if(cacheStrategy == CacheStrategy.FIFO) {
                return new FIFO<T>(s);
            }
            if(cacheStrategy == CacheStrategy.LRU) {
                return new LRU<T>(s);
            }
            return new LRU<T>(s);
        }
    }

    public static void main(String[] args) {
        CacheFactory<String> factory = new CacheFactory<>();
        CacheBase<String> cache = factory.getCache(CacheStrategy.LRU, 2);
        cache.put("1","one");
        cache.put("2","two");
        cache.show();
        cache.get("1");
        cache.get("3");
        cache.put("3","three");
        cache.show();
        cache.put("4","four");
        cache.show();
        cache.put("3","threeeeee");
        cache.get("3");
        cache.show();
        cache.clear();
        cache.put("5","five");
        cache.get("5");
        cache.show();
    }
}
