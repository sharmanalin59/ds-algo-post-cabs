package dp;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nalin.sharma on 13/09/21
 */
public class BigFile {
    static class LinkedList {
        static class Node {
            public Node(String s) {
                this.s = s;
            }

            String s;
            Node nxt;
        }
        Node start, end;
        void add(String d) {
            if(start == null && end == null) {
                start = end = new Node(d);
            }
            else {
                end.nxt = new Node(d);
                end = end.nxt;
            }
        }
        void show() {
            Node tmp = start;
            System.out.println();
            while(tmp != null) {
                System.out.println(tmp.s+" ");
                tmp = tmp.nxt;
            }
        }
    }
    public static void main(String[] args) {
        //List<String> l = new LinkedList<>();

        LinkedList l = new LinkedList();
        for(int i = 1; i < 21; i++) {
            l.add("row"+ i +"data is this");
        }
        l.show();

        //implementation
        LinkedList.Node oldRow = null;
        int A = 3, B = 2;

        int rowNum = 1;
        LinkedList.Node tmp = l.start;

        int lwind = - 1, rwin = -1;

        while(tmp != null) {

            /*String row = tmp.s;
            if(rowNum == A) {
                oldRow = l.start;
            }
            if(match(rowNum)) {
                if(lwind == - 1 && rwin == -1) {
                    lwind = rowNum - A;
                    rwin =  A + B;
                }
                else if(rwin <= rowNum + ) {
                    rwin = rowNum + B;
                }
            }*/

            rowNum++;
            tmp = tmp.nxt;
        }
    }
    static boolean match(int rowNum) {
        if(rowNum % 5 == 0) {
            return true;
        }
        return false;
    }
}
