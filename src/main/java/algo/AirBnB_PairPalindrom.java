package algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author nalin.sharma on 14/10/21
 */
public class AirBnB_PairPalindrom {
    static class Node {
        public Node(char c) {
            this.c = c;
        }
        char c;
        Node l,m,r;
        boolean ends;
    }

    static Node add(Node start, String s, int i) {
        if(start == null) {
            start = new Node(s.charAt(i));
        }
        if(start.c < s.charAt(i)) {
            start.r = add(start.r, s, i);
        }
        else if(start.c > s.charAt(i)) {
            start.l = add(start.l, s, i);
        }
        else {
            if(i < s.length() - 1) {
               start.m = add(start.m, s, i+1);
            }
            else {
                start.ends = true;
            }
        }
        return start;
    }
    static Node find(Node start, String s, int i) {
        if(start == null) {
            return null;
        }
        if(start.c < s.charAt(i)) {
            return find(start.r, s, i);
        }
        else if(start.c > s.charAt(i)) {
            return find(start.l, s, i);
        }
        else {
            if(i > 0) {
                return find(start.m, s, i-1);
            }
            return start;
        }
    }
    public static void main(String[] args) {
        String list[] = {"geekf", "geeks", "or",
                "keeg", "abc", "bc","aba", "aa","bb"};//{"geeks", "babxl", "bab"};

        Node start = null, found;
        Set<String> output = new HashSet<>();
        //Set<String> palins = new HashSet<>();
        for(String s: list) {
            start = add(start, s, 0);
        }
        for(String s: list) {
            found = find(start, s, s.length() - 1);
            if(found == null) {
                continue;
            }
            if(found.ends) {
                String rev = rev(s);
                if(!isPalin(s, 0, s.length() - 1) && !output.contains(rev+s))
                output.add(s+rev);
            }
            List<String> palinList = new ArrayList<>();
            findNextPalin(found.m, "", palinList);
            for(int i = 0; i < palinList.size(); i++) {
                output.add(rev(s) +""+ palinList.get(i) +"" +s);
            }
            //cartesion pairs of palindromes
           /* if(isPalin(s, 0, s.length() - 1))
            palins.add(s);*/
        }
        /*List<String> palinsList = new ArrayList<>(palins);
        for(int i = 0; i < palinsList.size(); i++) {
            for(int j = i+1; j < palinsList.size(); j++) {
                String s = palinsList.get(i) + palinsList.get(j);
                if(isPalin(s, 0, s.length() - 1))
                output.add(palinsList.get(i) + palinsList.get(j));
            }
        }*/
        System.out.println(output);
    }

    private static String rev(String s) {
        char [] arr = new char [s.length()];
        int l = 0;
        while(l < arr.length) {
            arr[l] = s.charAt(arr.length - 1 - l);
            l++;
        }
        return new String(arr);
    }

    private static void findNextPalin(Node found, String cur, List<String> palinList) {
        if(found == null) {
            return;
        }
        if(found.ends) {
            if(isPalin(cur+found.c,0, (cur+found.c).length() - 1)) {
                palinList.add(cur+found.c);
            }
        }
        findNextPalin(found.m, cur+found.c,palinList);
        findNextPalin(found.l, cur, palinList);
        findNextPalin(found.r, cur, palinList);
    }

    private static boolean isPalin(String cur, int l, int h) {
        if(l > h) {
            return true;
        }
        return cur.charAt(l) == cur.charAt(h) && isPalin(cur, l + 1, h - 1);
    }
}
