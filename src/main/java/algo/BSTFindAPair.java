package algo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nalin.sharma on 17/08/21
 *
 * find pair such sume equals n
 * https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
 *
 *
 * BST from-:
 * https://www.quora.com/What-is-the-highest-balance-factor-of-a-node-in-a-binary-search-tree
 *
 */
public class BSTFindAPair {
    static class Node {
        Node(int m) {
            n = m;
        }
        int n;
        Node l,r;
    }

    public static void main(String[] args) {
        Node start = new Node(7);
        start.l = new Node(3);
        start.r = new Node(11);

        start.l.l = new Node(1);
        start.l.l.l = new Node(0);
        start.l.l.r = new Node(2);
        start.l.r = new Node(5);
        start.l.r.l = new Node(4);
        start.l.r.r = new Node(6);

        start.r.l = new Node(9);
        start.r.l.l = new Node(8);
        start.r.l.r = new Node(10);
        start.r.r = new Node(13);
        start.r.r.l = new Node(12);
        start.r.r.r = new Node(14);

        pair(start, 28);
    }

    private static void pair(Node start, int n) {
        Deque<Node> stack1 = new LinkedList<>();
        Deque<Node> stack2 = new LinkedList<>();
        Node tmp = start;
        while(tmp != null) {
            stack1.push(tmp);
            tmp = tmp.l;
        }
        tmp = start;
        while(tmp != null) {
            stack2.push(tmp);
            tmp = tmp.r;
        }
        boolean left;
        while(true) {
            if(stack1.isEmpty() || stack2.isEmpty()) {
                return;
            }
            if(stack1.peek().n != stack2.peek().n &&
                    stack1.peek().n + stack2.peek().n == n) {
                System.out.println(stack1.peek().n+" "+stack2.peek().n);
                return;
            }
            if(stack1.peek().n + stack2.peek().n < n) {
                left = true;
            }
            else {
                left = false;
            }
            if(left && !stack1.isEmpty()) {
                Node pop = stack1.pop();
                if(pop.r != null) {
                    Node pRight = pop.r;
                    while(pRight != null && pRight.n + stack2.peek().n <= n) {
                        pRight = pRight.r;
                    }
                    while(pRight != null) {
                        stack1.push(pRight);
                        pRight = pRight.l;
                    }
                }
            }
            if(!left && !stack2.isEmpty()) {
                Node pop = stack2.pop();
                if(pop.l != null) {
                    Node pLeft = pop.l;
                    while(pLeft != null && stack1.peek().n + pLeft.n >= n) {
                        pLeft = pLeft.l;
                    }
                    while(pLeft != null) {
                        stack1.push(pLeft);
                        pLeft = pLeft.r;
                    }
                }
            }
        }
    }
}
