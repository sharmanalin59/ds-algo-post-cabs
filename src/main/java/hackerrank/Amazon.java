package hackerrank;

import java.util.*;

/**
 * @author nalin.sharma on 10/06/21
 */
public class Amazon {

    public static int countGroups(List<String> related) {
        // Write your code here
        //related
        int R = related.size(), C = related.get(0).length();
        char arr [] [] = new char [R][C];
        boolean visited [] [] = new boolean [R][C];
        int r = 0, c = 0;
        for(int i = 0; i < R; i++) {
            String s = related.get(i);
            for(int j = 0; j < s.length(); j++) {
                arr[r][c++] = s.charAt(j);
            }
            r++;
            c = 0;
        }

        int group = 0;
        Set<Integer> groupSet = new HashSet<>();
        for(int i = 0; i < R; i++) {
            if(groupSet.contains(i)) {
                continue;
            }
            for(int j = 0; j < C; j++) {
                if(groupSet.contains(j)) {
                    continue;
                }
                if(arr[i][j] == '1' && !visited[i][j]) {
                    group++;
                    link(i, j, arr, R, C, visited, groupSet);
                }
            }
        }
        return group;
    }
    static void link(int i, int j, char [][] arr, int R, int C, boolean[][] visited,Set<Integer> groupSet) {
        if(!visited[i][j]) {
            //visit relations
            if(arr[i][j] == '1' && arr[j][i] == '1') {
                visited[i][j] = true;
                visited[j][i] = true;
                groupSet.add(i);
                groupSet.add(j);
            }
            for(int m = 0; m < C; m++) {
                if(arr[i][m] == '1' && !visited[i][m])
                link(i, m, arr, R, C, visited,groupSet);
                if(arr[m][j] == '1' && !visited[m][j])
                link(j, m, arr, R, C, visited,groupSet);
            }
        }
    }
    public static void main(String[] args) {
        List<String> related = new ArrayList<>();
        related.add("1100");
        related.add("1110");
        related.add("0110");
        related.add("0001");
        countGroups(related);
    }
}
