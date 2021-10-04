package tree;

/**
 * @author nalin.sharma on 24/06/21
 */
public class ArrayJump_O_n {
    public static void main(String[] args) {

        int r [] = {5,0,0,0,3,0,0,1};
        double a = 10.0;
        System.out.println("min :"+minJumps(r));


        int arr [] = {5,0,1,4,2,1,1,0};

        if(arr[0] == 0) {
            return;
        }
        int jumps = 1;
        int steps = arr[0];
        int reachability = 0;
        int i = 0;
        for(; i < arr.length; i++) {
            if(i == arr.length-1) {
                System.out.println(jumps);
                return;
            }
            reachability = Math.max(reachability, i + arr[i]);
            steps--;

            if(steps == 0) {
                jumps++;
                if(i >= reachability) {
                    return;
                }
                steps = reachability - i;
            }
        }

    }

    static int minJumps(int arr[])
    {
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        // Start traversing array
        for (int i = 1; i < arr.length; i++) {
            // Check if we have reached
// the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0) {
                // we must have used a jump
                jump++;

                // Check if the current
// index/position or lesser index
                // is the maximum reach point
// from the previous indexes
                if (i >= maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }

}
