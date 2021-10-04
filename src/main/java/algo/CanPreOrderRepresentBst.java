package algo;

import java.util.Deque;
import java.util.LinkedList;

public class CanPreOrderRepresentBst {

    /**
     *
     *      40
     *    /   \
     *  30    80
     *   \      \
     *   35     100
     *
     *
     *         9
     *       5
     *     3   6
     *   0    a   7
     *       b
     *   in order
     *
     *          40
     *       35
     *          20
     *
     *
     *   {40, 30, 35, 20, 80, 100}
     *   s  80, 100
     *   q  30, 20, 35, 40
     *
     */

    public static void main(String[] args) {
        int pre [] = {40, 30, 35, 20, 80, 100};
        boolean canRepresent = isPReOrderBst(pre);
        System.out.println(canRepresent);
    }

    private static boolean isPReOrderBst(int[] pre) {
        if(pre == null) {
            return false;
        }
        if(pre.length == 1) {
            return true;
        }
        int i = 1;
        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> queue = new LinkedList<>();
        stack.push(pre[0]);
        while(i < pre.length) {
            while(i < pre.length && pre[i] < pre[i-1]) {
                stack.push(pre[i++]);
            }
            if(i < pre.length) {
                while(!stack.isEmpty() && stack.peek() < pre[i]) {
                    queue.add(stack.pop());
                }
                stack.push(pre[i++]);
            }
        }
        while(!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        int last, current;
        last = queue.remove();
        while (!queue.isEmpty()) {
            current = queue.remove();
            if(current < last) {
                return false;
            }
            last = current;
        }
        return true;
    }
}
