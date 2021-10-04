package graph;

import java.util.*;

/**
 * @author nalin.sharma on 01/06/21
 */
public class Amazon {

    public static void main(String[] args) {
        int A = 2;
        /*B = [  [1. 2]
        [1, 3] ]*

         A = 5
 B = [  [1. 2]
        [1, 3]
        [2, 3]
        [1, 4]
        [4, 5]
     ]
         */
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

        //B.add(new ArrayList<>());

        //B.add(new ArrayList<>());
        B.add(new ArrayList<>());

        B.get(0).add(1);
        B.get(0).add(2);

        //B.add(0, new ArrayList<>());

        /*B.add(new ArrayList<>());
        B.add(new ArrayList<>());
        B.add(new ArrayList<>());

        B.get(1).add(2);
        B.get(2).add(1);

        B.get(1).add(3);
        B.get(3).add(1);*/

        /*B.add(new ArrayList<>());
        B.add(new ArrayList<>());
        B.add(new ArrayList<>());
        B.add(new ArrayList<>());
        B.add(new ArrayList<>());
        B.get(0).add(2);
        B.get(1).add(1);
        B.get(0).add(3);
        B.get(2).add(1);
        B.get(0).add(4);
        B.get(3).add(1);

        B.get(1).add(3);
        B.get(2).add(2);
        B.get(3).add(5);
        B.get(4).add(4);*/

        System.out.println(solve(A, B));
    }
    static public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        ArrayList<ArrayList<Integer>> C = new ArrayList<>();
        for(int i = 0; i <= A; i++) {
            C.add(new ArrayList<>());
        }
        for(int i = 0; i < B.size(); i++) {
            C.get(B.get(i).get(0)).add(B.get(i).get(1));
            C.get(B.get(i).get(1)).add(B.get(i).get(0));
        }
        boolean[] visited = new boolean[A+1];
        boolean[] current = new boolean[A+1];

        if(dfsUtil(C,A,visited,current)) {
            return 1;
        }
        return 0;

    }

    static private boolean dfsUtil(ArrayList<ArrayList<Integer>> B,int A,
                            boolean [] visited, boolean [] current) {
        for(int i = 1; i <= A; i++) {
            if(visited[i]) {
                continue;
            }
            if(dfs(-1,i,B,A,visited,current))
            return true;
        }
        return false;
    }

    static private boolean dfs(int from, int i, ArrayList<ArrayList<Integer>> B, int A,
                        boolean [] visited, boolean [] current) {
        if(!current[i]) {
            visited[i] = true;
            current[i] = true;

            for(int j = 0; j < B.get(i).size(); j++) {
                if(!current[B.get(i).get(j)]) {
                    boolean res = dfs(i,B.get(i).get(j),B,A,visited,current);
                    if(res) {
                        return res;
                    }
                }
                else if(B.get(i).get(j) != from) {
                    return true;
                }
            }
            current[i] = false;
        }
        return false;
    }
}
