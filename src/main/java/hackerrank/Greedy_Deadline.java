package hackerrank;

import algo.revolut.A;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author nalin.sharma on 02/07/21
 *
 *
 *
 *  Deadline  1   4   2   6
 *  Profit    10  20  15  49
 */
public class Greedy_Deadline {
    static class DeadlineProfit {
        DeadlineProfit(int d, int p) {
            deadline = d;
            profit = p;
        }
     int deadline, profit;
    }
    public static void main(String[] args) {
        int deadline [] = {1, 4, 2, 2, 6, 6};
        int profit [] = {10, 20, 15, 21, 49, 30};
        List<DeadlineProfit> list = new ArrayList<>();
        list.add(new DeadlineProfit(1,10));
        list.add(new DeadlineProfit(4,20));
        list.add(new DeadlineProfit(2,15));
        list.add(new DeadlineProfit(2,21));
        list.add(new DeadlineProfit(6,49));
        list.add(new DeadlineProfit(6,30));
        list.sort((dp1, dp2) -> Integer.compare(dp2.profit, dp1.profit));
        int maxDeadline = list.stream().max((dp1, dp2) -> Integer.compare(dp1.deadline, dp2.deadline)).get().deadline;
        System.out.println(maxDeadline);
        DeadlineProfit [] arranged = new DeadlineProfit[maxDeadline+1];
        for(int i = 0; i < list.size(); i++) {
            for(int j = list.get(i).deadline; j > 0; j--) {
                if(arranged[j] == null) {
                    arranged[j] = list.get(i);
                    break;
                }
            }
        }
        Arrays.stream(arranged).filter(Objects::nonNull).forEachOrdered(i -> {
            System.out.println(i.deadline + " : " +i.profit);
        });
    }
}
