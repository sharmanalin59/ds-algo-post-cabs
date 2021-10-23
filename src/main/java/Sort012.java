/**
 * @author nalin.sharma on 17/10/21
 */
public class Sort012 {
    public static void main(String[] args) {
        int arr [] = {1,0};
        int l = 0, m = 0, r = arr.length - 1, tmp;
        while(m <= r) {
            if(arr[m] == 1) {
                m++;
            }
            else if(arr[m] == 0) {
                tmp = arr[m];
                arr[m] = arr[l];
                arr[l] = tmp;
                l++;
            }
            else if(arr[m] == 2) {
                tmp = arr[m];
                arr[m] = arr[r];
                arr[r] = tmp;
                r--;
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
