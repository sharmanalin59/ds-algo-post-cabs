package gs;

/**
 * @author nalin.sharma on 16/09/21
 */
public class OneMg {
    public static void main(String[] args) {
        int arr [] = {3,4,5,6,7,1,1,2};
        int target = 8;

        System.out.println(binarySearch(arr, 0, arr.length - 1, target));
    }

    private static int binarySearch(int[] arr, int l, int h, int target) {
        if(l > h) {
            return -1;
        }
        int mid = (l + h) / 2;
        if(arr[mid] == target) {
           return mid;
        }
        else if(arr[mid] > arr[l]) {
            if(target < arr[mid] && target >= arr[l])
            return binarySearch(arr, l, mid - 1, target);
            else
                return binarySearch(arr,mid + 1, h, target);
        }
        else if(arr[mid] < arr[h]) {
            if(target > arr[mid] && target <= arr[h])
                return binarySearch(arr, mid + 1, h, target);
            else
                return binarySearch(arr, l,mid - 1, target);
        }
        return -1;
    }
}
