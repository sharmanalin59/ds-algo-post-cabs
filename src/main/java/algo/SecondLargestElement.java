package algo;

public class SecondLargestElement {

    /**
     *
     * Assumptions-:
     *
     * The assumption is that, this is a hard coded requirement to find 2nd largest element in
     * worst case O(n*m) but if it was a flexible requirement like finding kth largest element,
     * we would have used extra space (n+m) of a Max Heap holding n elements just to keep the time
     * complexity in O(n*m)
     *
     * End of Assumptions-:
     *
     */

    /**
     *
     * Driver program
     *
     * @param args
     */

    public static void main(String[] args) {

        String arr[] = {
                "-214748364801",
                "-214748364802"
        };

        Object secMax = secondMax(arr);

        //the callee of the method secondMax takes a decision based on if found
        if (secMax instanceof Integer) { //not found
            System.out.println(secMax);
        } else if (secMax instanceof String) { //found
            System.out.println("\"" + secMax + "\"");
        }

    }

    /**
     * returns the second largest element in worst case O(n*m)
     * where n is total number of integers and m is the average
     * length of each integer.
     *
     * @param arr
     * @return
     */

    public static Object secondMax(String[] arr) {
        int greatestInd = 0,
                secGreatestInd = -1;
        System.out.println();
        if (arr != null && 1 < arr.length) {
            int compare_i_greatest_Ind;
            for (int i = 1; i < arr.length; i++) {
                compare_i_greatest_Ind = compare(arr[i], arr[greatestInd]);
                if (compare_i_greatest_Ind == 1) {
                    secGreatestInd = greatestInd;
                    greatestInd = i;
                } else if (compare_i_greatest_Ind == -1 && (secGreatestInd == -1 || compare(arr[i], arr[secGreatestInd]) == 1)) {
                    //update secGreatestInd
                    secGreatestInd = i;
                }
            }
        }
        if (secGreatestInd == -1) return secGreatestInd;
        else return "" + arr[secGreatestInd];
    }


    /**
     * compares each characters of strings a and b
     * @param a
     * @param b
     * @return -1,0,1
     */

    private static int compareChars(String a, String b) {
        if (a.length() > b.length()) {
            return 1;
        } else if (a.length() < b.length()) {
            return - 1;
        } else {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) > b.charAt(i)) {
                    return 1;
                } else if (a.charAt(i) < b.charAt(i)) {
                    return - 1;
                }
            }
            return 0;
        }
    }


    /**
     * compares a and b integers and takes sign of the number
     * into account
     * @param a
     * @param b
     * @return -1,0,1
     */

    private static int compare(String a, String b) {
        if (a.charAt(0) == '-' && b.charAt(0) == '-') {
            return compareChars(b, a);
        } else if (a.charAt(0) == '-' && b.charAt(0) != '-') {
            return - 1;
        } else if (a.charAt(0) != '-' && b.charAt(0) == '-') {
            return 1;
        } else {
            return compareChars(a, b);
        }
    }
}