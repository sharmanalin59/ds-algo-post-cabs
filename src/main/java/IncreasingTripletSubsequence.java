/**
 * @author nalin.sharma on 24/09/21
 */
public class IncreasingTripletSubsequence {
    // Function to find the triplet
    public static void find3Numbers(int[] nums)
    {

        // If number of elements < 3
        // then no triplets are possible
        if (nums.length < 3){
            System.out.print("No such triplet found");
            return;
        }

        // track best sequence length
        // (not current sequence length)
        int seq = 1;

        // min number in array
        int min_num = nums[0];

        // least max number in best sequence
        // i.e. track arr[j] (e.g. in
        // array {1, 5, 3} our best sequence
        // would be {1, 3} with arr[j] = 3)
        int max_seq = Integer.MIN_VALUE;

        // save arr[i]
        int store_min = min_num;

        // Iterate from 1 to nums.size()
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == min_num)
                continue;

            else if (nums[i] < min_num)
            {
                min_num = nums[i];
                continue;
            }

            // this condition is only hit
            // when current sequence size is 2
            else if (nums[i] < max_seq) {

                // update best sequence max number
                // to a smaller value
                // (i.e. we've found a
                // smaller value for arr[j])
                max_seq = nums[i];

                // store best sequence start value
                // i.e. arr[i]
                store_min = min_num;
            }

            // Increase best sequence length &
            // save next number in our triplet
            else if (nums[i] > max_seq)
            {
                seq++;

                // We've found our arr[k]!
                // Print the output
                if (seq == 3)
                {
                    System.out.println("Triplet: " + store_min +
                            ", " + max_seq + ", " + nums[i]);
                    return;
                }
                max_seq = nums[i];
            }
        }

        // No triplet found
        System.out.print("No such triplet found");
    }

    // Driver program
    public static void main(String[] args)
    {
        int[] nums = {6,3,5,20};

        // Function Call
        find3Numbers(nums);
    }
}
