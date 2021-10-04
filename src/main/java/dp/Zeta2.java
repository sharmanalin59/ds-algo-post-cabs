package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nalin.sharma on 11/09/21
 */
public class Zeta2 {
    public static void main(String[] args) {
        //List<Integer> l = new ArrayList<>();
        int n = 15;
        List<int[]> out = new ArrayList<>();
        int[] in = new int[n];
        for(int i = 1; i <= n; i++) {
            in[i-1] = i;
        }
        //System.out.println(a.equals(b));
        //rec(in, 0, out);

        int[] output = {0};
        rec(in, 0, output);
        System.out.println("output "+output[0]);
        /*for(int i = 0; i < out.size(); i++) {
            System.out.println();
            for(int j = 0; j < n; j++) {
                System.out.print(out.get(i)[j]+" ");
            }
        }*/
    }

    private static void rec(int[] in, int ind, int[] output) {
        if(ind == in.length) {
            //collect relevant
            //collect(in, out);
            boolean collect = true;
            for(int i = 0; i < in.length; i++) {
                if(!((i+1) % in[i] == 0 || in[i] % (i+1) == 0)) {
                    collect = false;
                    break;
                }
            }
            if(collect) {
                output[0]++;
            }
            return;
        }
        int tmp;
        int[] nIn = Arrays.copyOf(in, in.length);
        for(int i = ind; i < in.length; i++) {
            tmp = nIn[ind];
            nIn[ind] = nIn[i];
            nIn[i] = tmp;
            rec(nIn, ind + 1, output);
        }
    }

    private static void rec(int[] in, int ind, List<int[]> out) {
        if(ind == in.length) {
            //collect relevant
            collect(in, out);
            return;
        }
        int tmp;
        int[] nIn = Arrays.copyOf(in, in.length);
        for(int i = ind; i < in.length; i++) {
            tmp = nIn[ind];
            nIn[ind] = nIn[i];
            nIn[i] = tmp;
            rec(nIn, ind + 1, out);
        }
    }

    private static void collect(int[] in, List<int[]> out) {
        boolean collect = true;
        for(int i = 0; i < in.length; i++) {
            if(!((i+1) % in[i] == 0 || in[i] % (i+1) == 0)) {
                collect = false;
                break;
            }
        }
        if(collect) {
            out.add(in);
        }
    }
}
