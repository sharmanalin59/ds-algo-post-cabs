package algo.google;

/**
 * @author nalin.sharma on 30/07/21
 */
public class StockBuySell {
    public static void main(String[] args) {
        int price[] = {1,2,3,4,2,1,3,6};
        int total = 0;
        int cnt = 0, j = 1;
        while(j < price.length) {
            if(price[j] > price[j-1]) {
                cnt++;
            }
            else {
                if(cnt > 0) {
                    total += (price[j-1] - price[j-1-cnt]);
                    cnt = 0;
                }
            }
            if(j == price.length -1 && cnt > 0) {
                total += (price[j] - price[j-cnt]);
            }
            j++;
        }
        System.out.println(total);
    }
}
