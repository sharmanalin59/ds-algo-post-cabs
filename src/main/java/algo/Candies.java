package algo;

public class Candies {
    public static void main(String[] args) {
        int rating [] = {4,4,3,4,3,3};
        int arr [] = new int[rating.length];
        int ind = 0;
        boolean equal = false;
        int decCnt = 0;

        while(ind < rating.length && arr.length > 1) {
            if(ind == 0) {
                if(rating[0] < rating[1]){
                    arr[ind] = 1;
                }
                else if(rating[0] == rating[1]){
                    equal = true;
                    arr[ind] = 1;
                }
            }
            else {
                if (rating[ind] > rating[ind - 1]) {
                    //currentCandy++;
                    if(decCnt > 0) {
                        assignDecremenetedVal(arr, ind, decCnt);
                        //check 1st index for decremnt
                        if (ind - decCnt - 2 >= 0
                                && rating[ind - decCnt - 2] < rating[ind - decCnt - 1]
                                && arr[ind - decCnt - 2] >= arr[ind - decCnt - 1]) {
                            arr[ind - decCnt - 1] = arr[ind - decCnt - 2] + 1;
                        }
                    }
                    arr[ind] = arr[ind-1] + 1;
                    decCnt = 0;
                }
                else if (rating[ind] < rating[ind - 1]) { // 5 3 2 8
                    decCnt++;
                    if(equal) {
                        arr[ind -1]++;
                        equal = false;
                    }
                }
                else{
                    equal = true;
                    arr[ind] = 1;
                    //check 1st index for decremnt
                    if(decCnt > 0) {
                        assignDecremenetedVal(arr, ind, decCnt);
                        //check 1st index for decremnt
                        if (ind - decCnt - 2 >= 0
                                && rating[ind - decCnt - 2] < rating[ind - decCnt - 1]
                        && arr[ind - decCnt - 2] >= arr[ind - decCnt - 1]) {
                            arr[ind - decCnt - 1] = arr[ind - decCnt - 2] + 1;
                        }
                    }
                    decCnt = 0;
                }
            }
            ind++;
        }
        if(decCnt > 0) {
            assignDecremenetedVal(arr, ind, decCnt);
            //check 1st index for decremnt
            if (ind - decCnt - 2 >= 0
                    && rating[ind - decCnt - 2] < rating[ind - decCnt - 1]
                    && arr[ind - decCnt - 2] >= arr[ind - decCnt - 1]) {
                arr[ind - decCnt - 1] = arr[ind - decCnt - 2] + 1;
            }
        }

        //print
        for(int i = 0 ; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
    }

    private static void assignDecremenetedVal(int[] arr, int ind, int decCnt) {
        int cnt = decCnt + 1;
        for(int i = ind - decCnt - 1; i < ind; i++) {
            arr[i] = cnt--;
        }
    }
}
