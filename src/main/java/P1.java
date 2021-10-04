import java.util.*;

/**
 * @author nalin.sharma on 20/09/21
 */
public class P1 {
    static public boolean increasingTriplet(int[] nums) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        TreeMap<Integer, Object> tree = new TreeMap<>();
        for(int i = 2; i < nums.length; i++) {
            tree.put(nums[i], null);
        }
        q.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(tree.higherKey(nums[i]) != null && q.peek() < nums[i]) {
                return true;
            }
            q.add(nums[i]);
            tree.remove(nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5};
        increasingTriplet(arr);
    }
}
