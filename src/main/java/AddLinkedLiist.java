/**
 * @author nalin.sharma on 19/09/21
 */
public class AddLinkedLiist {
    static class LL<T> {
        static class Node<T> {
            public Node(T t) {
                this.t = t;
            }
            T t;
            Node<T> next;
        }
        Node<T> start, end;
        int size = 0;

        public int getSize() {
            return size;
        }

        void add(T t) {
            if(start == null) {
                start = end = new Node<>(t);
            }
            else {
                end.next = new Node<>(t);
                end = end.next;
            }
            size++;
        }
        void addStart(T t) {
            if(start == null) {
                start = end = new Node<>(t);
            }
            else {
                Node<T> nStart = new Node<>(t);
                nStart.next = start;
                start = nStart;
            }
            size++;
        }
        void show() {
            Node<T> tmp = start;
            while(tmp != null) {
                System.out.print(tmp.t+" ");
                tmp = tmp.next;
            }
        }
    }

    public static void main(String[] args) {
        LL<Integer> l1 = new LL<>();
        l1.add(9);
        l1.add(9);
        l1.add(2);
        LL<Integer> l2 = new LL<>();
        l2.add(8);
        if(l1.getSize() > l2.getSize()) {
            while(l1.getSize() > l2.getSize()) {
                l2.addStart(0);
            }
        }
        else if(l1.getSize() < l2.getSize()) {
            while(l2.getSize() > l1.getSize()) {
                l1.addStart(0);
            }
        }
        LL<Integer> l3 = new LL<>();
        int o = addRec(l1.start, l2.start, l3);
        if(o == 1) {
            l3.addStart(1);
        }
        l3.show();
    }

    private static int addRec(LL.Node<Integer> start1, LL.Node<Integer> start2, LL<Integer> l3) {
        if(start1 == null || start2 == null) {
            return 0;
        }
        int out = addRec(start1.next, start2.next, l3);
        l3.addStart((start1.t+start2.t+out)%10);
        return (start1.t+start2.t+out)/10;
    }


}
