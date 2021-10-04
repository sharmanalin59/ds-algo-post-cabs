package hackerrank;

/**
 * @author nalin.sharma on 21/07/21
 *
 * int maxReach = arr[0];
 *         int step = arr[0];
 *         int jump = 1;
 *
 *         for(int i = 0; i < arr.length; i++) {
 *             if (i == arr.length - 1)
 *                 //return jump;
 *             maxReach = Math.max(maxReach, i + arr[i]);
 *             step--;
 *             if (step == 0) {
 *                 jump++;
 *                 if (i >= maxReach)
 *                     //return -1;
 *                 step = maxReach - i;
 *             }
 *         }
 */
public class ArrayJump {
    public static void main(String[] args) {
        int arr [] = {3,1,2,4,3,0,0,0,0};
        if(arr == null || arr[0] == 0) {
            System.out.println("-1");
            return;
        }
        int steps = arr[0];
        int largestJump = arr[0];
        int jumps = 1;
        int i = 0;
        for(; i < arr.length; i++) {
            if(arr.length - 1 == i) {
                break;
            }

            largestJump = Math.max(largestJump, i + arr[i]);

            if(steps == 0) {
                if(largestJump <= i) {
                    break;
                }
                steps = largestJump - i;
                jumps++;
            }

            steps--;
        }

        if(i == arr.length - 1) {
            System.out.println(jumps);
        }
        else {
            System.out.println("-1");
        }
    }
}
