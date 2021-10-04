package algo.thoughtspot;

public class DecreasingTriplet {
    public static void main(String[] args) {
    int arr[] = {8, 4, 2, 1};
    int cnt[] = {0};
    merge_sort(arr,0,arr.length-1,cnt);
    System.out.println(cnt[0]);
}

    private static void merge_sort(int[] arr, int l, int h, int[] cnt) {
        if(h > l) {
            int mid = (h+l)/2 ;
            merge_sort(arr,l,mid,cnt);
            merge_sort(arr,mid+1,h,cnt);
            merge(arr,l,mid,h,cnt);
        }
    }

    private static void merge(final int[] arr, final int l,
                              final int mid, final int h, final int[] cnt) {
        int temp [] = new int[h-l+1];
        int p = l, q = mid + 1, out = 0;
        while(p <= mid && q <= h) {
            if (arr[p] <= arr[q]) {
                cnt[0] += (out - (p - l));
                temp[out++] = arr[p++];
            }
            else if (arr[p] > arr[q]) {
                //cnt[0] += (q - out - l);
                temp[out++] = arr[q++];
            }
        }
        while(p <= mid) {
            cnt[0] += (h-mid);
            temp[out++] = arr[p++];
        }
        while(q <= h) {
            temp[out++] = arr[q++];
        }
        out = 0;
        while(out < temp.length) {
            arr[l+out] = temp[out++];
        }
    }

}
