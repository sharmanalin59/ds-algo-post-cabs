public class Zeta_Array {
    public static void main(String[] args) {
        int arr[] = {6,5,4,3,2,1};
        int k = 4;
        int sum_right = 0, sum_left = 0, sum = 0;
        if (k > arr.length) {
            System.out.println(-1);
            return;
        }
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr.length - i <= k) {
                sum_right += arr[i];
            }
            else {
                break;
            }
        }

        sum = sum_right;

        for(int i = 0; i < arr.length; i++) {
            if(i == k) {
                break;
            }
            sum_left += arr[i];
            if(arr.length - k + i < arr.length) {
                sum_right -= arr[arr.length - k + i];
            }
            if(sum_left + sum_right > sum) {
                sum = sum_left + sum_right;
            }
        }
        System.out.println(sum);
    }
}
