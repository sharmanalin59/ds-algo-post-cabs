package algo;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList();
        stack.add(5);
        stack.add(2);
        stack.add(1);

        rev(stack);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void rev(Deque stack) {
        if(!stack.isEmpty()) {
            int pop = (int) stack.pop();

            rev(stack);
            
            atBottom(stack, pop);
        }
    }

    private static void atBottom(Deque stack, int pop) {
        if(!stack.isEmpty()) {
            int nPop = (int) stack.pop();
            atBottom(stack, pop);
            stack.push(nPop);
        }
        else {
            stack.push(pop);
        }
    }
}
