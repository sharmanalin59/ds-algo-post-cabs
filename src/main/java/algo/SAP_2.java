package algo;

/**
 * @author nalin.sharma on 14/10/21
 *
 * Given an array A of positive integers.
 * Your task is to find the leaders in the array.
 * An element of array is leader if it is greater than or
 * equal to all the elements to its right side.
 * The rightmost element is always a leader.
 *
 * A[] = {16,17,4,3,5,2}
 * Output: 17 5 2
 *
 * 1 2 3 4 5
 * 5 4 3 2 1
 */
public class SAP_2 {
    public static void main(String[] args) {
       int arr[] = {5,5,5};//{7, 5, 2, 15, 1, 6, 4};//{16,17,4,3,5,2};
       if(arr == null || arr.length == 0) {
           return;
       }
       int max = arr[arr.length - 1];
       System.out.println(arr[arr.length - 1]);
       for(int i = arr.length - 2; i>=0; i--) {
           if(arr[i] >= max) {
               System.out.println(arr[i]);
               max = arr[i];
           }
       }
    }
}
