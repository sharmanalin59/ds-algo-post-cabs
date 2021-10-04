package algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author nalin.sharma on 22/07/21
 *
 * Design custom array list which dont allows duplicate and is immutable
 */
public class ImmutableList {
    static interface MyList<E> {
        void add(E e);
        E get(int i);
    }
    /*static class MyArrayList<E> implements MyList<E> {
        List<E> l = new ArrayList<>();
        Set<E> set = new HashSet<>();
        @Override
        public void add(E e) {
            if(!set.contains(e)) {
                l.add(e);
                set.add(e);
            }
        }

        @Override
        public E get(int i) {

        }
    }*/
}
