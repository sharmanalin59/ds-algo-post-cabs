import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nalin.sharma on 27/09/21
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int [] arr = {4,3,3,2,6,7,8,2};
        Deque<Integer> stack = new LinkedList<>();
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] > stack.peek()) {
                System.out.println(stack.pop()+" "+arr[i]);
            }
            stack.push(arr[i]);
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop()+" -1");
        }
    }
}
