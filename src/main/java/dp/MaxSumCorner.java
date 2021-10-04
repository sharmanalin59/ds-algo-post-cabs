package dp;

/**
 * @author nalin.sharma on 13/09/21
 */
public class MaxSumCorner {
    public static void main(String[] args) {
        int k = 5;
        int arr [] = {5,4,7,1,6,4};
        int maxSum = 0, lasKSum = 0, ind = 0;
        if (k > arr.length) {
            k = arr.length;
        }
        for(int i = arr.length - k; i < arr.length; i++) {
            lasKSum += arr[i];
        }
        maxSum = lasKSum;
        for(int i = arr.length - k; i < arr.length; i++) {
            lasKSum -= arr[i];
            lasKSum += arr[ind];
            maxSum = Math.max(maxSum, lasKSum);
            ind++;
        }
        System.out.println(maxSum);
    }
}
