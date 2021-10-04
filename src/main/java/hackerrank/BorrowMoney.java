package hackerrank;

import java.util.*;

/**
 * @author nalin.sharma on 08/06/21
 *
 *
 * https://www.hackerrank.com/challenges/borrowing-money/problem
 *
 */
public class BorrowMoney {

    public static List<Integer> demandingMoney(List<Integer> money, List<List<Integer>> roads) {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= money.size(); i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < roads.size(); i++) {
            adj.get(roads.get(i).get(0)).add(roads.get(i).get(1));
            adj.get(roads.get(i).get(1)).add(roads.get(i).get(0));
        }

        //find leaf
        boolean [] visited = new boolean[money.size()+1];
        int leaf = leaf(1, -1, adj);
        //find max
        return max(leaf, money, adj);
    }

    static List<Integer> max(int i, List<Integer> money, List<List<Integer>> adj) {
        int max_even = -1, max_odd = -1, max = -1;
        int [] maxCnt = {0};
        for(int j = 0; j < adj.get(i).size(); j++) {
            max_even = Math.max(max_even,
                    dfs_max(adj.get(i).get(j), -1, 0, true, money, adj));
        }

        max_odd = dfs_max(i, -1, 0, true, money, adj);

        if(max_even < max_odd) {
            dfs_cnt(i, -1, true, maxCnt,0, max_odd, money, adj);
            max = max_odd;
        }

        else {
            max = max_even;
            if(max_even == max_odd) {
                dfs_cnt(i, -1, true, maxCnt, 0, max_odd, money, adj);
            }
            //even
            for(int j = 0; j < adj.get(i).size(); j++) {
                int [] maxCntEven = {0};
                dfs_cnt(adj.get(i).get(j), -1, true, maxCntEven,0, max_odd, money, adj);
                maxCnt[0] = maxCnt[0] + maxCntEven[0];
            }
        }
        return Arrays.asList(max, maxCnt[0]);
    }

    static void dfs_cnt(int i, int old, boolean flag, int [] cnt, int collected, int max_collected,
                       List<Integer> money, List<List<Integer>> adj) {

        if(collected + money.get(i-1) == max_collected) {
            //count zero
            cnt[0]++;

            int [] cnt_0 = {0};
            if(flag) {
                dfs_cnt_zero(i, old, i, true, cnt_0, money, adj);
            }
            else {
                dfs_cnt_zero(i, old, i, false, cnt_0, money, adj);
            }
            cnt[0] += cnt_0[0];
        }

        for(int j = 0; j < adj.get(i).size(); j++) {
            int neighbor = adj.get(i).get(j);
            if(old == neighbor) {
                continue;
            }

            if(flag) {
                dfs_cnt(neighbor, i, false, cnt,collected + money.get(i - 1), max_collected, money, adj);
            }
            else {
                dfs_cnt(neighbor, i, true, cnt, collected, max_collected, money, adj);
            }
        }
    }

    /**
     *
     * 1 2 3 4 0 0 1 (T)
     * 1 2 3 4 0 1
     * 1 2 3 0 0 1
     * 1 2 3 0 1
     */
    static void dfs_cnt_zero(int i, int old, int start, boolean flag, int [] cnt_0,
                            List<Integer> money, List<List<Integer>> adj) {
        for(int j = 0; j < adj.get(i).size(); j++) {
            int neighbor = adj.get(i).get(j);
            if(old == neighbor && money.get(neighbor) != 0) {
                continue;
            }
            if(flag) {
                if(money.get(neighbor - 1) == 0) {
                    cnt_0[0]++;
                }
                dfs_cnt_zero(neighbor, i, start, false, cnt_0, money, adj);
            }
            else {
                dfs_cnt_zero(neighbor, i, start, true, cnt_0, money, adj);
            }
        }
    }

    static int dfs_max(int i, int old, int collected, boolean flag, List<Integer> money, List<List<Integer>> adj) {
        int neighborCnt = 0, neighbor = -1, max = 0;
        for(int j = 0; j < adj.get(i).size(); j++) {
            neighbor = adj.get(i).get(j);
            if(old == neighbor) {
                continue;
            }
            neighborCnt++;
            if(flag) {
                max = Math.max(max, dfs_max(neighbor, i, collected, false, money, adj));
            }
            else {
                max = Math.max(max, dfs_max(neighbor, i, collected, true, money, adj));
            }
        }
        //last node(leaf)
        if(neighborCnt == 0 && flag) {
            return money.get(i-1);
        }
        else if(neighborCnt == 0) {
            return 0;
        }
        if(flag) {
            return money.get(i-1) + max;
        }
        else {
            return max;
        }
    }

    static private int leaf(int i, int old, List<List<Integer>> adj) {
        if(adj.get(i).size() == 1) {
            return i;
        }
        int ret;

        if(adj.get(i).get(0) != old)
            ret = leaf(adj.get(i).get(0), i, adj);
        else
            ret = leaf(adj.get(i).get(1), i, adj);

        if(ret != -1) {
            return ret;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> roads = new ArrayList<>();
        List<Integer> money = Arrays.asList(75, 75, 50, 75, 100);
        roads.add(Arrays.asList(3,5));
        roads.add(Arrays.asList(2,5));
        roads.add(Arrays.asList(2,3));
        roads.add(Arrays.asList(4,5));
        roads.add(Arrays.asList(1,3));
        roads.add(Arrays.asList(2,4));
        System.out.println(demandingMoney(money, roads));
    }
}
