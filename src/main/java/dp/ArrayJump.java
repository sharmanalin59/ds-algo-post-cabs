package dp;

/**
 * @author nalin.sharma on 11/09/21
 */
public class ArrayJump {
    public static void main(String[] args) {
        int a [] = {8,5,3,4,2,0,0,0,0,1};
        int jumps = 1, steps = a[0], maxJumpTo = -1;
        for(int i = 0; i < a.length; i++) {
            if(i==a.length - 1) {
                System.out.println(jumps);
                return;
            }
            if(i + a[i] > maxJumpTo) {
                maxJumpTo = i + a[i];
            }
            if(steps == 0) {
                if(maxJumpTo <= i) {
                    System.out.println(-1);
                    return;
                }
                steps = maxJumpTo - i;
                jumps++;
            }
            steps--;
        }
        System.out.println(-1);
    }
}
