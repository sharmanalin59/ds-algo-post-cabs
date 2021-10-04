/**
 * @author nalin.sharma on 26/08/21
 */
public class Cars24P1 {
    public static void main(String[] args) {
        int [] [] arr = {
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 1},
                {1, 0, 1, 1}
        };
        int R = arr.length, C= arr[0].length;
        boolean brr [] [] = new boolean[R][C];
        int islands = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
               if(arr[i][j] == 1 && !brr[i][j]) {
                   islands++;
                   dfsMarkVisitedConnectedOnes(arr, i, j, R, C, brr);
               }
            }
        }
        System.out.println(islands);
    }

    private static void dfsMarkVisitedConnectedOnes(int[][] arr, int i, int j, int R, int C, boolean[][] brr) {
        if(i == R || j == C) {
            return;
        }
        if(brr[i][j]) {
            return;
        }
        brr[i][j] = true;
        //visit neighbors
        if(i + 1 < R && arr[i+1][j] == 1 && !brr[i+1][j]) {
            dfsMarkVisitedConnectedOnes(arr, i+1, j, R, C, brr);
        }
        if(j + 1 < C && arr[i][j+1] == 1 && !brr[i][j+1]) {
            dfsMarkVisitedConnectedOnes(arr, i, j+1, R, C, brr);
        }
        if(i - 1 >= 0 && arr[i-1][j] == 1 && !brr[i-1][j]) {
            dfsMarkVisitedConnectedOnes(arr, i-1, j, R, C, brr);
        }
        if(j - 1 >= 0 && arr[i][j-1] == 1 && !brr[i][j-1]) {
            dfsMarkVisitedConnectedOnes(arr, i, j-1, R, C, brr);
        }

        //diagonal
        if(i - 1 >= 0 && j - 1 >= 0 && arr[i-1][j-1] == 1 && !brr[i-1][j-1]) {
            dfsMarkVisitedConnectedOnes(arr, i-1, j-1, R, C, brr);
        }
        if(i - 1 >= 0 && j + 1 < C && arr[i-1][j+1] == 1 && !brr[i-1][j+1]) {
            dfsMarkVisitedConnectedOnes(arr, i-1, j+1, R, C, brr);
        }

        if(i + 1 < R && j - 1 >= 0 && arr[i+1][j-1] == 1 && !brr[i+1][j-1]) {
            dfsMarkVisitedConnectedOnes(arr, i+1, j-1, R, C, brr);
        }
        if(i + 1 < R && j + 1 < C && arr[i+1][j+1] == 1 && !brr[i+1][j+1]) {
            dfsMarkVisitedConnectedOnes(arr, i+1, j+1, R, C, brr);
        }
    }


}
