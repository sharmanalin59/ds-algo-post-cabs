package algo;

public class MergeKSortedArray {
    //using merge sort's merge
    public static void main(String[] args) {
        int a [] [] = {
                {2, 4, 8},
                {3},
                {9,14,19,20}
        };
        int s = 0, j = 0;

        for(int i = 0; i<a.length;i++) {
            s += a[i].length;
        }
        System.out.println(s);

        int k [] = new int[a.length];
        int smallest = a[0][0];
        int smallestInd = -1;

        int out [] = new int[s];
        int o = 0;
        while (j<s) {
            //find lowest
            for(int m = 0; m < k.length; m++) {
                if(k[m] < a[m].length && (smallestInd == -1 || a[m][k[m]] < smallest)) {
                    smallest = a[m][k[m]];
                    smallestInd = m;
                }
            }
            out[o++] = smallest;
            k[smallestInd]++;
            smallestInd = -1;
            j++;
        }
        for(int i = 0; i < out.length; i++) {
            System.out.print(" "+out[i]);
        }
    }
}
