package tree;

/**
 * @author nalin.sharma on 24/06/21
 */
public class ArrayJumo {
    public static void main(String[] args) {
        int arr [] = {5,0,1,4,2,1,1,0};
        int dp [] = new int [arr.length];
        dp[0] = 0;
        int ind = 1;

        for(;ind < arr.length; ind++) {
            for(int j = 0; j < ind; j++) {
                if(arr[0] >= ind) {
                    dp[ind] = 1;
                    break;
                }
                else if(j + arr[j] >= ind && (dp[ind] == 0 || dp[ind] > dp[j] + 1)) {
                    dp[ind] = dp[j] + 1;
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(" "+dp[i]);
        }

/*
        int brr[] = {5,0,1,3,2,1,0,0};
        int cind = 0, nInd = -1, maxReach = -1, cnt = 0, i = 0;
        boolean found = false;
        while(i < brr.length) {
            maxReach = -1;
            for(int j=i; j <= i+brr[i]; j++) {
                if(j >= brr.length - 1) {
                    found = true;
                }
                else if(maxReach == -1 || (j+brr[j]) > maxReach) {
                    maxReach = j + brr[j];
                    nInd = j;
                }
            }
            cnt++;
            if(maxReach <= i+brr[i]) {
                break;
            }
            i = nInd;
            if(found){
                break;
            }
        }
        if(found) {
        System.out.println("\n count :"+cnt);
        }*/

    }
}
