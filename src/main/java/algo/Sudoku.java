package algo;

public class Sudoku {

    public static void main(String[] args) {
        int  [][] arr = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        // 3 1 6 5 7 8 4 9 2
        // 5 2 9 1 3 4 7 6 8
        boolean [][] brr = {
                {true,false,true,true,false,true,true,false,false},
                {true,true,false,false,false,false,false,false,false},
                {false,true,true,false,false,false,false,true,true},
                {false,false,true,false,true,false,false,true,false},
                {true,false,false,true,true,true,false,false,true},
                {false,true,false,false,true,false,true,false,false},
                {true,true,false,false,false,false,true,true,false},
                {false,false,false,false,false,false,false,true,true},
                {false,false,true,true,false,true,true,false,false},
        };

        /*

           3 1 6 5 7 8 4 9 2
           5 2 9 1 3 4 7 6 8
           4 8 7 6 2 9 5 3 1
           2 6 3 4 1 5 9 8 7
           9 7 4 8 6 3 1 2 5
           8 5 1 7 9 2 6 4 3
           1 3 8 9 4 7 2 5 6
           6 9 2 3 5 1 8 7 4
           7 4 5 2 8 6 3 1 9

         */
        boolean done = rec(0,0,arr,brr);
        System.out.println(done);

    }

    private static boolean rec(int i, int j, int[][] arr, boolean[][] brr) {
        if(j == 9) {
            i++;
            j = 0;
        }
        if(i == 9) {
            return true;
        }
        if(!brr[i][j]) {
            boolean sol = false;
            for(int m = 1; m < 10; m++) {
                if(isSafe(i,j, arr, m)) {
                    arr[i][j] = m;
                    sol = rec(i, j + 1, arr, brr);
                }
                if(sol) {
                    return true;
                }
            }
            //important step to backtrack
            arr[i][j] = 0;
        }
        else {
            return rec(i, j + 1, arr, brr);
        }
        return false;
    }

    private static boolean isSafe(int i, int j, int[][] arr, int item) {
        for (int x = 0; x < 9 ; x++) {
            if(arr[i][x] == item || arr[x][j] == item) {
                return false;
            }
        }
        int x = i/3, y = j/3;
        x *= 3;
        int originalY;
        originalY = y * 3;
        int cnt = 3;
        for(int n = 0; n < cnt; n++) {
            y = originalY;
            for(int m = 0; m < cnt; m++) {
                if(arr[x][y++] == item){
                    return false;
                }
            }
            x++;
        }
        return true;
    }
}
