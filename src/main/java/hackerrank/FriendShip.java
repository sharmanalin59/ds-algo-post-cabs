package hackerrank;

import java.util.*;

/**
 * @author nalin.sharma on 13/06/21
 *
 * https://www.hackerrank.com/challenges/value-of-friendship/problem
 */
public class FriendShip {
    public static int valueOfFriendsship(int n, List<List<Integer>> friendships) {
        // Write your code here
        int R = friendships.size(), C = friendships.get(0).size();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < friendships.size(); i++) {
            List<Integer> friends = friendships.get(i);
            adj.get(friends.get(0)).add(friends.get(1));
            adj.get(friends.get(1)).add(friends.get(0));

        }
        boolean [] visited = new boolean [n+1];
        int [] total = {0};
        for(int i = 1; i < visited.length; i++) {
            if(!visited[i]) {
                Set<Integer> set = new HashSet<>();
                dfs(i, adj, visited, set, total);
            }
        }
        return total[0];
    }
    static void dfs(int i, List<List<Integer>> adj, boolean [] visited, Set<Integer> set, int[] total) {
        if(!visited[i]) {
            visited[i] = true;
            set.add(i);
            total[0] += (set.size() * (set.size() - 1));
            //visit neighbors
            for(int j = 0; j < adj.get(i).size(); j++) {
                if(!visited[adj.get(i).get(j)]) {
                    dfs(adj.get(i).get(j), adj, visited, set, total);
                }
            }
        }
    }
    static List<Integer> getList(int... a) {
        List<Integer> l = new ArrayList<>();
        l.add(a[0]);
        l.add(a[1]);
        return l;
    }
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> friendships = new ArrayList<>();
        friendships.add(getList(1,2));
        friendships.add(getList(3,2));
        friendships.add(getList(4,2));
        friendships.add(getList(4,3));
        System.out.println(valueOfFriendsship(5, friendships));
    }
}
