package algo;

import java.util.Deque;
import java.util.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinSwap {
    static int minimumSwaps(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i + 1 != arr[i]) {
                sum++;
            }
        }
        return sum-1;
    }
    public static void main(String[] args) {
        int arr [] = {2 ,31 ,1 ,38 ,29 ,5 ,44 ,6 ,12 ,18 ,39 ,9 ,48 ,49 ,13 ,11 ,7 ,27 ,14 ,33 ,50 ,21 ,46 ,23 ,15 ,26 ,8 ,47 ,40 ,3 ,32 ,22 ,34 ,42 ,16 ,41 ,24 ,10 ,4 ,28 ,36 ,30 ,37 ,35 ,20 ,17 ,45 ,43 ,25 ,19};
        System.out.println(minimumSwaps(arr));

        List<Integer> l = new LinkedList<>();
        //((Deque<Integer>)l).ad

      /*  Stream.of(" ddd ")
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
*/
        Scanner scan = new Scanner(System.in);
        //System.out.println(scan.next());

        StringBuilder s = new StringBuilder("abc");
        String del = s.substring(s.length()-2, s.length());
        System.out.println(del);
        s.deleteCharAt(s.length()-1);
        s.deleteCharAt(s.length()-1);
        System.out.println(s);
    }
}
