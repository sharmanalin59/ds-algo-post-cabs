/**
 * @author nalin.sharma on 17/10/21
 */
public class NQueen {
    public static void main(String[] args) {
        int arr[][] = {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0}
        };
        int total[] = {0};
        rec(arr, 0, total);
        System.out.println(total[0]);
    }

    private static void rec(int[][] arr, int i, int [] total) {
        if(i == 8) {
            //show
            total[0]++;
            System.out.println("\nsol\n");
            show(arr);
            return;
        }
        for(int j = 0; j < 8; j++) {
            if(safe(arr, i, j)) {
                arr[i][j] = 1;
                rec(arr, i + 1, total);
                arr[i][j] = 0; //back track
            }
        }
    }

    private static boolean safe(int[][] arr, int x, int y) {
        boolean safe = true;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i][y] == 1 || arr[x][i] == 1) {
                return false;
            }
        }
        //diagnal
        int x1 = x, y1 = y;
        while(x1 >= 0 && y1 >= 0) {
            if(arr[x1--][y1--] == 1) {
                return false;
            }
        }
        x1 = x; y1 = y;
        while(x1 <= 7 && y1 <= 7) {
            if(arr[x1++][y1++] == 1) {
                return false;
            }
        }

        x1 = x; y1 = y;
        while(x1 >= 0 && y1 <= 7) {
            if(arr[x1--][y1++] == 1) {
                return false;
            }
        }
        x1 = x; y1 = y;
        while(x1 <= 7 && y1 >= 0) {
            if(arr[x1++][y1--] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void show(int[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println();
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
        }
    }
}
