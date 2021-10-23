/**
 * @author nalin.sharma on 13/10/21
 */
public class MyHashMap {

    static class HM<K, V> {

        static class Node<K,V> {
            K k;
            V v;

            public Node(K k, V v) {
                this.k = k;
                this.v = v;
            }

            Node<K,V> nxt;
        }
        int size = 10;

        Node<K,V> [] arr = new Node[size];

        V put(K k, V v) {
            int hash = k.hashCode()%size;

            Node<K,V> entry = arr[hash];
            if(entry == null) {
                arr[hash] = new Node<>(k,v);
            }
            else {
                while(entry.nxt != null)
                    if(entry.k.equals(k)) {
                        entry.v = v;
                        return v;
                    }
                    entry = entry.nxt;
                }
                entry.nxt = new Node<>(k,v);
            return v;
        }




    }
}
