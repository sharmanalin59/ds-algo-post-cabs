/**
 * @author nalin.sharma on 17/10/21
 */
public class LargestSun {
    public static void main(String[] args) {
        int arr [] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int gMax = arr[0], max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            max = Math.max(max + arr[i], arr[i]);
            gMax = Math.max(gMax, max);
        }
        System.out.println(gMax);
    }
}
