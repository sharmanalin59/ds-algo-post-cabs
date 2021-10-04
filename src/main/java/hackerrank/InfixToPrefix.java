package hackerrank;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nalin.sharma on 20/06/21
 */
public class InfixToPrefix {
    static int pre(char c) {
        switch (c) {
            case '+' :
            case '-' :
                return 0;
            case '/' : return 2;
            case '*' : return 1;
            case '^' : return 3;
            default : return -1;
        }
    }
    static boolean isOperator(char c) {
        switch (c) {
            case '+' :
            case '-' :
            case '/' :
            case '*' :
            case '^' :
                return true;
            default : return false;
        }
    }
    /*static void preO(String c) {
        switch (c) {
            case "+": System.out.println("nalin");
        }
    }*/

    private static void infixToPostFix(String s) {
        Deque<Character> stack = new LinkedList<>();
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if('(' == c) {
                stack.push(c);
            }
            else if(')' == c) {
                while(!stack.isEmpty()) {
                    char pop = stack.pop();
                    if(pop == '(') {
                        break;
                    }
                    out.append(pop);
                }
            }
            else if(isOperator(c)) {
                while(!stack.isEmpty()) {
                    if(stack.peek() == '(') {
                        break;
                    }
                    if(pre(stack.peek()) > pre(c)) {
                        out.append(stack.pop());
                    }
                    else {
                        break;
                    }
                }
                stack.push(c);
            }
            else {
                out.append(c);
            }

        }
        while(!stack.isEmpty()) {
            out.append(stack.pop());
        }

        //preO("+");
        System.out.println(out);
    }

    private static void infixToPreFix(String s) {
        Deque<Character> stack = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                cnt++;
            }
        }
        cnt *= 2;
        char [] arr = new char [s.length() - cnt];
        int out = arr.length - 1;

        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == ')') {
                stack.push(c);
            }
            else if(c == '(') {
                while(!stack.isEmpty()) {
                    char op = stack.pop();
                    if(op == ')') {
                        break;
                    }
                    arr[out--] = op;
                }
            }
            else if(isOperator(c)) {
                while(!stack.isEmpty()) {
                    if(stack.peek() != ')' && pre(stack.peek()) > pre(c)) {
                        arr[out--] = stack.pop();
                    }
                    else {
                        break;
                    }
                }
                stack.push(c);
            }
            else {
                arr[out--] = c;
            }
        }
        while(!stack.isEmpty()) {
            arr[out--] = stack.pop();
        }

        //preO("+");
        System.out.println(new String(arr).trim());
    }

    public static void main(String[] args) {
        String s = "a/b*(f*g+h/i)/c+d*e";
        // postfix = ab/fg*hi/+c/*de*+
        // prefix =  +*/ab/+*fg/hic*de
        //a+b*c+d  post= abc*d++  pre= ++a*bcd
        //String s = "a+b*c+d";
        System.out.println("experesssion :"+ s);
        infixToPostFix(s);
        infixToPreFix(s);
    }

}
