package algo;

/**
 * @author nalin.sharma on 06/09/21
 */
public class MaxSubArrayProduct {
    public static void main(String[] args) {
    int arr [] = {6, -3, -10, 0, 2};
    int maxPro = arr[0], maxProLast = arr[0], minProLast = arr[0];
    for(int i = 1; i < arr.length; i++) {
        int maxval = maxProLast * arr[i];
        int minval = minProLast * arr[i];
        maxProLast = Math.max(arr[i], Math.max(maxval, minval));
        minProLast = Math.min(arr[i], Math.min(maxval, minval));
        maxPro = Math.max(maxPro, maxProLast);
    }
    System.out.println(maxPro);
    }
}
