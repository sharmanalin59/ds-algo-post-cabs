package dp;

/**
 * @author nalin.sharma on 13/09/21
 *
 *   6 4 2 4 6 8 5 3 2
 */
public class BuySellStock {
    public static void main1(String[] args) {
        int arr [] = {30,20,10,0,20,400,20,10,20};
        int total = 0, buy = -1, i = 1;
        while(i < arr.length) {

            while(i+1 < arr.length && arr[i] > arr[i+1]) {
                i++;
            }
            if(i == arr.length - 1) {
                break;
            }
            //buy
            buy = i;
            i++;
            while(i < arr.length && arr[i] > arr[i-1]) {
                i++;
            }
            total += (arr[i-1] - arr[buy]);
            buy = i;
        }
        System.out.println(total);
    }


    static int maxProfit(int prices[], int size)
    {

        // maxProfit adds up the difference between
        // adjacent elements if they are in increaisng order
        int maxProfit = 0;

        // The loop starts from 1
        // as its comparing with the previous
        for (int i = 1; i < size; i++)
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        return maxProfit;
    }

    // Driver code
    public static void main(String[] args)
    {
        int price[] = { 30,20,10,70,100,30,20,10,20,30 };
        int n = price.length;

        System.out.print(maxProfit(price, n));
    }
}
