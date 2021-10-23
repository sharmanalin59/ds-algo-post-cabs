/**
 * @author nalin.sharma on 13/10/21
 */
public class Array {
    public static void main(String[] args) {
        int arr [] = {0,0,1,1,2};
        int N = arr.length;
        for(int i = 0; i < arr.length; i++) {
            arr[arr[i]%N] += N;
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]%N);
            if(arr[i] >= N * 2) {
                System.out.println("dup "+i);
            }
        }
    }
}
