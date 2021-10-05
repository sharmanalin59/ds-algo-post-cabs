import java.util.HashMap;
import java.util.Map;

/**
 * @author nalin.sharma on 05/10/21
 */
public class CreateTree {
    static class Node {
        public Node(int i) {
            this.i = i;
        }
        int i;
        Node l,r;
    }
    static void show(Node start) {
        if(start != null) {
            show(start.l);
            System.out.print(start.i+" ");
            show(start.r);
        }
    }
    public static void main(String[] args) {
        int in[] = {3, 1, 4, 0, 5, 2};
        int pre[] = {0, 1, 3, 4, 2, 5};
        Node start = null;
        int ind [] = {0};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        start = create(start, in, pre, ind, map, 0, in.length - 1);
        show(start);
    }

    private static Node create(Node start, int[] in, int[] pre, int[] ind,
                               Map<Integer, Integer> map, int l, int h) {
        int num = pre[ind[0]++];
        if(start == null) {
            start = new Node(num);
        }
        int numInd = map.get(num);
        if(numInd - 1 >= l) {
            start.l = create(start.l, in, pre, ind, map, l, numInd - 1);
        }
        if(numInd + 1 <= h) {
            start.r = create(start.r, in, pre, ind, map,numInd + 1, h);
        }
        return start;
    }
}
