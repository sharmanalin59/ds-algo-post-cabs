package graph;

/**
 * @author nalin.sharma on 18/06/21
 */
public class Graph_MST {
    static int nCTwo(int n) {
        return n* (n-1)/2;
    }

    public static void main(String[] args) {

        long l = 1;
        long g = l - 1;
        int n = 10;

        int m = 45;

        int s = 19;

        // Write Your Code Here
        if(m > n-1) {
            int nMinusOnec2 = nCTwo(n-1);
            //if(m > nMinusOnec2 + 2) {
            int option1;
            if(nMinusOnec2 < m) {
                option1 = ((m - nMinusOnec2) * (s - (n - 2))) + nMinusOnec2;
            }
            else {
                option1 = ((s - (n - 2))) + (m - 1);
            }
            int rem = s%(n-1);
            int edge = s/(n-1);

            int option2 = Integer.MAX_VALUE;
            if(nCTwo(n - 1) < m) {
                option2 = (edge * nCTwo(n - 1)) + ((edge + rem) * (m - nCTwo(n - 1)));
            }
            else {
                option2 = (edge * (m-1)) + (edge + rem);
            }
            if(nCTwo(n-rem) < m) {
                option2 = Math.min( option2,
                        (edge * nCTwo(n - rem)) + ((edge + 1) * (m - nCTwo(n - rem))));
                //option2 = (edge * nCTwo(n - rem)) + ((edge + 1) * (m - nCTwo(n - rem)));
            }
            else {
                option2 = (edge * (m-rem)) + ((edge + 1) * rem);
            }
            if(option1 < 0 || (option2 < option1)) {
                System.out.println(option2);
            }
            else {
                System.out.println(option1);
            }
        }
        else {
            System.out.println(s);
        }
    }
}
