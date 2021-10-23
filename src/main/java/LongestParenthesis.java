import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nalin.sharma on 06/10/21
 */
public class LongestParenthesis {
    static void longest() {
        //wrooong solutiioon resented iin interview
        String s = "((()()()()(((())";
        Deque<Character> stack = new LinkedList<>();
        int max = 0, cMax = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            }
            else if(c == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                    cMax += 2;
                    max = Math.max(max, cMax);
                }
                else {
                    cMax = 0;
                }
            }
        }
        System.out.println(max);
    }
    //correct solution
    static void loong() {
        String s = "((()()()()(((()))))";
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int cMax = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            }
            else if(c == ')') {
                stack.pop();
                if(stack.peek() != -1) {
                    cMax = Math.max(cMax, i - stack.peek());
                }
                else {
                    cMax = Math.max(cMax, i + 1);
                }
            }
        }
        System.out.println(cMax);
    }
    public static void main(String[] args) {
        //longest();
        loong();
    }
}
