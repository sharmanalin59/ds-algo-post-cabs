package dp;

import java.util.*;

/**
 * @author nalin.sharma on 13/09/21
 */
public class Joveo2 {
    static class Node {
        Node(char c) {
            val = c;
        }
        char val;
        Node left;
        Node right;
    }
    static Node rec(String preorder, int[] cnt, Node start) {
        if(cnt[0] < preorder.length())  {
            if(start == null) {
                start = new Node(preorder.charAt(cnt[0]++));
            }
            if(start.val == '*') {
                start.left = rec(preorder, cnt, start.left);
                start.right = rec(preorder, cnt, start.right);
            }
            return start;
        }
        return null;
    }
    static void print(Node start) {
        if(start != null) {
            System.out.print(start.val+" ");
            print(start.left);
            print(start.right);
        }
    }
    public static void printPre(Node root, String s) {
        if(root != null) {
            if(root.val != '*') {
                System.out.println(root.val+" "+s.length()+" "+s);
            }
            else {
                printPre(root.left, s+"0");
                printPre(root.right, s+"1");
            }
        }
    }
    public static void charEncoding(Node root, String s, Map<Character, String> map) {
        if(root != null) {
            if(root.val != '*') {
                //System.out.println(root.val+" "+s.length()+" "+s);
                map.put(root.val, s);
            }
            else {
                charEncoding(root.left, s+"0",map);
                charEncoding(root.right, s+"1",map);
            }
        }
    }
    public static void main(String[] args) {
        int c [] = {0};
        Node start = null;
        start = rec("*a**!*dc*rb", c, start);
        //print(start);
        printPre(start, "");
        Map<Character, String> map = new LinkedHashMap<>();
        charEncoding(start, "", map);
        System.out.println(map);

    }
}
