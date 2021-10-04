package algo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LargestRect {
    static class Wrapper {
        Wrapper(int i, int a) {
            index = i;
            area = a;
        }
        int index;
        int area;
    }
    public static void main(String[] args) {

        /**
         |
         |           |        |
         |     |     |     .  |
         |     |  |  |     |  |
         |  |  |  |  |     |  |
         |  |  |  |  |  |  |  |  .
         |  |  |  |  |  |  |  |  |  |
         |  |  |  |  |  |  |  |  |  |
         0  1  2  3  4  5  6  7  8  9
            16345
         5*3269 = 16345
         8*3269 = 26152
                   3269
                    421
         */
        Object o;
        //((List<Integer>)o).sort();
        //8979,4570,6436,5083,7780,3269,5400,7579,2324,2116
        // 5,6,3,4
        //1702 * 30
        int[] h = {6873,7005,1372,5438,1323,9238,9184,2396,4605,162,7170,9421,4012,5302,6277,2438,4409,3391,4956,4488,622,9365,5088,6926,2691,6909,1050,2824,3538,5801,8468,411,9158,9841,2201,481,5431,1385,2877,36,1547,48,5809,1911,1702,8439,4349,6111,1830,5657,6951,8804,5022,8391,2083,7713,5300,3133,6890,5190,5286,1710,1953,4445,7903,4154,4926,3335,5539,4156,9723,3438,556,1885,5349,2258,324,6050,4722,8506,1707,1673,7310,3081,65,9393,7147,1717,8878,389,6908,4165,2099,5213,8610,3,9368,3536,9690,1259};
            int i = 1;
            Deque<Wrapper> stack = new LinkedList<>();
            stack.push(new Wrapper(0,0));
            int area = 0, t_area, left_area = 0, right_area;
            while(i < h.length) {
                while(i < h.length && h[i] > h[i-1]) {
                    stack.push(new Wrapper(i++,0));
                }
                Wrapper wrapper = null;
                while(!stack.isEmpty() && i < h.length && h[stack.peek().index] >= h[i]) {
                    wrapper = stack.pop();
                    t_area = h[wrapper.index] * (i - wrapper.index);
                    if(t_area + wrapper.area > area) {
                        area = t_area + wrapper.area;
                    }
                }
                if(i < h.length) {
                    if(stack.isEmpty()) {
                        left_area = h[i] * (i);
                    }
                    else {
                        left_area = h[i] * (i - stack.peek().index - 1);
                    }
                    stack.push(new Wrapper(i++,left_area));
                }
            }
            //anything left in stack
            while(!stack.isEmpty()) {
                Wrapper wrapper = stack.pop();
                t_area = h[wrapper.index] * (h.length - wrapper.index);
                t_area += wrapper.area;
                if(t_area > area) {
                    area = t_area;
                }
            }
            System.out.println(area);
        }
}
