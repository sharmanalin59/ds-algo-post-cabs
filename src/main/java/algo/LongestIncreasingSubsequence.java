package algo;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int [] arr = {2 ,9, 4, 5, 6, 1, 10, 0};
        int [] lis = new int[arr.length];
        Arrays.fill(lis, 1);
        for(int i = 1; i < arr.length; i++) {
            int max = 1;
            for(int j = i - 1; j >= 0; j--)
            if(arr[j] < arr[i] && lis[j] + 1 > max) {
                max = lis[j] + 1;
            }
            lis[i] = max;
            System.out.print(" "+lis[i]);
        }
        int maxInd = 0;
        for(int i = 1; i < lis.length; i++) {
            if(lis[i]>lis[maxInd]) {
                maxInd = i;
            }
        }
        System.out.println();

        int maxVal = lis[maxInd];
        while(maxVal > 0) {
            if (lis[maxInd] == maxVal) {
                System.out.print(" "+arr[maxInd]);
                maxVal--;
            }
            maxInd--;
        }
    }
}
