/*
package algo;

import com.amazonaws.services.dynamodbv2.xspec.N;

import java.util.HashMap;
import java.util.Map;

public class CreateBstFromPreAndInOrder {

    private static class Node {
        Node(int c) {
            d = c;
        }
        int d;
        Node l,r;
    }
    static void show(Node start) {
        if (start != null) {
            show(start.l);
            System.out.println(start.d);
            show(start.r);
        }
    }
    public static void main(String[] args) {
        int pre [] = {2,1,0,6,5,4};
        int in [] = {0,1,2,4,5,6};
        int [] preInd = {0};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }

        Node start = create(null, pre, preInd, in, map, 0, in.length-1);
        show(start);

    }

    private static Node create(Node start, int[] pre, int[] preInd, int[] in,
                               Map<Integer, Integer> map, int l, int h) {
        if(preInd[0]<pre.length) {
            start = new Node(pre[preInd[0]++]);
            int ind = map.get(start.d);
            if (ind - 1 >= l)
            start.l = create(start.l, pre, preInd, in, map, l,ind - 1);
            if (ind + 1 <= h)
            start.r = create(start.r, pre, preInd, in, map,ind + 1, h);
        }
        return start;
    }
}
*/
