package tree;

/**
 * @author nalin.sharma on 24/06/21
 */
public class MedianInTwoSortedArrays {
    public static void main(String[] args) {
        int a[] = {2,3};
        int b[] = {12};
        //2,12,13,15,22,23,24
        int aInd = 0, bInd = 0;
        int median = (a.length + b.length)/2, cnt = 0, firstMedian = 0, secMedian = -1;
        boolean odd = (a.length + b.length)%2 != 0;
        while(cnt <= median) {
            firstMedian = secMedian;
            if(aInd == a.length) {
                bInd++;
                secMedian = b[bInd-1];
            }
            else if(bInd == b.length) {
                aInd++;
                secMedian = a[aInd-1];
            }
            else if(a[aInd] < b[bInd]) {
                aInd++;
                secMedian = a[aInd-1];
            }
            else {
                bInd++;
                secMedian = b[bInd-1];
            }
            cnt++;
        }

        if(odd) {
            System.out.println(secMedian);
        }
        else {
            System.out.println((double)(firstMedian + secMedian)/2.0);
        }
    }
}
