package algo;

public class LinkedListReverseK {
    public static void main(String[] args) {
        LL<Integer> ll = new LL<>();
        ll.addEnd(1);
        ll.addEnd(2);
        ll.addEnd(3);

        ll.show();
        ll.rev(5);
        ll.show();
    }
}
