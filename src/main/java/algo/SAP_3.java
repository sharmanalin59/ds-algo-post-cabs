package algo;

/**
 * @author nalin.sharma on 14/10/21
 *
 *
 * Given an array A of n positive numbers.
 * The task is to find the first Equilibium Point in the array.
 * Equilibrium Point in an array is a position such that the
 * sum of elements before it is equal to the sum of elements after it.
 *
 * A[] = {1,3,5,2,2}
 * Output: 2
 */
public class SAP_3 {
    public static void main(String[] args) {
        int arr [] = {9, 5, 5, 3, 1};//{1,3,5,2,2,1};
        int sum = 0, cSum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        cSum = arr[0];
        for(int i = 1; i < arr.length; i++) {
            cSum += arr[i];
            sum -= arr[i-1];
            if(cSum == sum) {
                System.out.println("sum equal at index "+ i+" sum is " +sum);
                break;
            }
        }
    }
}
