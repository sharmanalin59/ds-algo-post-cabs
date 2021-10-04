package gs;

/**
 * @author nalin.sharma on 15/09/21
 */
public class Rotation {
    public static void main(String[] args) {
        int arr [][] = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
        };

        //rotate90(arr);
        rotate180(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.println();
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+ "  ");
            }
        }
    }

    private static void rotate180(int[][] arr) {
        int tmp, tmp1, tmp2;
        for(int i = 0; i < arr.length / 2; i++) {
            for(int j = i; j < arr.length - i - 1; j++) {
                //p1 = arr[i][j];
                tmp = arr[j][arr[0].length - i - 1];
                arr[j][arr[0].length - i - 1] = arr[i][j];

                tmp1 = arr[arr.length - i - 1][arr[0].length - j - 1];
                arr[arr.length - i - 1][arr[0].length - j - 1] = tmp;

                tmp2 = arr[arr.length - j - 1][i];
                arr[arr.length - j - 1][i] = tmp1;

                arr[i][j] = tmp2;
            }
        }
    }

    private static void rotate90(int[][] arr) {
        int tmp, tmp1, tmp2;
        for(int i = 0; i < arr.length / 2; i++) {
            for(int j = i; j < arr.length - i - 1; j++) {
                //p1 = arr[i][j];
                tmp = arr[j][arr[0].length - i - 1];
                arr[j][arr[0].length - i - 1] = arr[i][j];

                tmp1 = arr[arr.length - i - 1][arr[0].length - j - 1];
                arr[arr.length - i - 1][arr[0].length - j - 1] = tmp;

                tmp2 = arr[arr.length - j - 1][i];
                arr[arr.length - j - 1][i] = tmp1;

                arr[i][j] = tmp2;
            }
        }
    }
}
