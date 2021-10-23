/**
 * @author nalin.sharma on 17/10/21
 */
public class KeyInSortedArray { //unique elements
    public static void main(String[] args) {
        int arr [] = {7,8,9,1,2,3,4,5,6};
        int k = 1;
        int ind = search(arr, 0, arr.length - 1, k);
        if(ind == -1)
            System.out.println("not found");
        else
        System.out.println("ind "+ind+" val "+arr[ind]);
    }

    private static int search(int[] arr, int l, int h, int k) {//my version
        if(l > h) {
            return -1;
        }
        int mid = (l+h)/2;
        if(arr[mid] == k) {
            return mid;
        }
        if(arr[mid] >= arr[l]) {
            if(k >= arr[l] && k <= arr[mid]) {
                return search(arr, l, mid - 1, k);
            }
            else {
                return search(arr,mid + 1, h, k);
            }
        }
        //if(arr[mid] < arr[h]) { //this is to handle when mid becomes equal to l
        else {
            if(k > arr[mid] && k <= arr[h]) { //extra condition l==mid, so search right side as mid is not solution
                return search(arr,mid + 1, h, k);
            }
            else {
                return search(arr,l, mid - 1, k);
            }
        }
    }

    static int searchgfg(int arr[], int l, int h, int key)
    {
        if (l > h)
            return -1;

        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;

        /* If arr[l...mid] is sorted */
        if (arr[l] <= arr[mid]) {
        /* As this subarray is sorted, we can quickly
        check if key lies in half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
        /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return search(arr, mid + 1, h, key);
        }

    /* If arr[l..mid] first subarray is not sorted, then arr[mid... h]
    must be sorted subarray */
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);

        return search(arr, l, mid - 1, key);
    }

}
