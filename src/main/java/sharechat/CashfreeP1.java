package sharechat;

/**
 * @author nalin.sharma on 28/08/21
 *
 * 2:25
 */
public class CashfreeP1 {
    /*

     5, 6, 7, 8, 9, 10, 1, 2, 3
     6   1
     3   8
     20 -1
     */


    public static void main(String[] args) {
        int arr [] = {3, 4, 5, 1, 2};
        int k = 3;
        int pivot = findPivot(arr, 0, arr.length - 1);
        System.out.println(pivot);
        if(arr[pivot] == k) {
            System.out.println(pivot);
            return;
        }
        int ind = -1;
        if(arr[pivot+1] <= k && arr[arr.length - 1] >= k) {
            ind = findKeyInd(arr, pivot + 1, arr.length - 1, k);
        }
        else {
            ind = findKeyInd(arr, 0, pivot, k);
        }
        System.out.println("two logN n find "+ind);
        System.out.println("direct logN find "+find(arr, 0, arr.length - 1, k));
    }

    private static int findKeyInd(int[] arr, int l, int h, int k) {
        /*if (h == l && arr[h] == k) {
            return l;
        }*/
        if(l > h) {
            return -1;
        }

        int mid = (l + h) / 2;
        if(arr[mid] == k) {
            return mid;
        }
        else if(arr[mid] < k) {
            return findKeyInd(arr, mid+1, h, k);
        }
        else {
            return findKeyInd(arr, l, mid-1, k);
        }

    }

    private static int findPivot(int[] arr, int l, int h) {
        if(l < h) {
            if(h == l + 1 && arr[h] < arr[l]) {
                return l;
            }
            int mid = (l+h)/2;
            if(arr[l] > arr[mid]) {
                return findPivot(arr, l, mid);
            }
            else if(arr[mid] > arr[h]) {
                return findPivot(arr, mid, h);
            }
        }
        return -1;
    }

    private static int find(int[] arr, int l, int h, int k) {
        if(l > h) {
            return -1;
        }
        int mid = (l+h)/2;
        if(k == arr[mid]) {
            return mid;
        }
        if(arr[l] < arr[mid]) {
            if(k > arr[mid] || k < arr[l]) {
                return find(arr, mid + 1, h, k);
            }
            else {
                return find(arr, l, mid - 1, k);
            }
        }
        else if (arr[mid] < arr[h]) {
            if(k > arr[h] || k < arr[mid]) {
                return find(arr, l, mid - 1, k);
            }
            else {
                return find(arr, mid + 1, h, k);
            }
        }
        return -1;
    }
}
