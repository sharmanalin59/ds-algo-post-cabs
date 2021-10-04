package hackerrank;

import java.util.*;

/**
 * @author nalin.sharma on 09/06/21
 */
public class NN {

    static class Wrapper {
        public Wrapper(int m, int n, int f){
            r = m;
            c = n;
            d = f;
        }
        int r,c,d;
    }

    public static void main(String[] args) {
        List<String> grid = new ArrayList<>();
        grid.add("..##");
        grid.add("#.##");
        grid.add("#...");

        int R = grid.size(), C = grid.get(0).length();
        int arr [] [] = new int [R][C];
        int i = 0, j = 0;
        for(int m = 0; m < grid.size(); m++) {
            for(int k = 0; k < grid.get(m).length(); k++) {
                String str = grid.get(m);
                if(str.charAt(k) == '#') {
                    arr[i][j++] = 0;
                }
                else {
                    arr[i][j++] = 1;
                }
            }
            j = 0;
            i++;
        }

        boolean visited[][] = new boolean[R][C];
        //BFS
        int maxTime = 5;
        Queue<GlobalLogic.Wrapper> q = new LinkedList<>();
        q.add(new GlobalLogic.Wrapper(0,0,0));

        int fr = arr.length - 1 , fc = arr[0].length - 1;
        while(!q.isEmpty()) {
            GlobalLogic.Wrapper w = q.remove();

            if(visited[w.r][w.c]) {
                continue;
            }
            visited[w.r][w.c] = true;

            if(fr == w.r && fc == w.c && w.d <= maxTime) {
                System.out.println("Yes");
            }
            if(w.r + 1 < R && arr[w.r + 1][w.c] == 1 && !visited[w.r + 1][w.c]) {
                q.add(new GlobalLogic.Wrapper(w.r + 1, w.c, w.d + 1));
            }
            if(w.r - 1 >= 0  && arr[w.r - 1][w.c] == 1 && !visited[w.r - 1][w.c]) {
                q.add(new GlobalLogic.Wrapper(w.r - 1, w.c, w.d + 1));
            }
            if(w.c + 1 < C && arr[w.r][w.c + 1] == 1 && !visited[w.r][w.c + 1]) {
                q.add(new GlobalLogic.Wrapper(w.r, w.c + 1, w.d + 1));
            }
            if(w.c - 1 >= 0 && arr[w.r][w.c - 1] == 1 && !visited[w.r][w.c - 1]) {
                q.add(new GlobalLogic.Wrapper(w.r, w.c - 1, w.d + 1));
            }
        }
        System.out.println("NO");

        int[] dis = new int[2];
        Arrays.stream(dis).sum();
    }
}
