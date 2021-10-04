package algo;

public class FarEyeNavigate {
    public static void main(String[] args) {
        int arr[] [] = {
                {2,0,0,3,0,3,0},
                {3,3,3,0,3,3,0},
                {3,3,0,3,3,1,0},
                {0,3,3,3,0,0,3},
        };
        boolean brr[] [] = {
                {false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false}
        };
        int R = arr.length, C = arr[0].length;
        int sourceR = 2, sourceC = 5;
        if(arr[sourceR][sourceC] == 1) {
            System.out.println(rec(R, C, arr, brr, sourceR, sourceC));
        }
        else {
            System.out.println(false);
        }
    }

    private static boolean rec(int R, int C, int[][] arr, boolean[][] brr, int r, int c) {
        if(r<0 || r >= R || c <0 || c >= C) {
            return false;
        }
        if(arr[r][c] == 2) {
            return true;
        }
        if(arr[r][c] == 0 || brr[r][c]) {
            return false;
        }
        brr[r][c] = true;
        boolean top = rec(R,C,arr,brr,r-1,c);
        boolean bottom = rec(R,C,arr,brr,r+1,c);
        boolean left = rec(R,C,arr,brr,r,c-1);
        boolean right = rec(R,C,arr,brr,r,c+1);
        return top || bottom || left || right;
    }
}
