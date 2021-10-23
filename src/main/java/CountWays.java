/**
 * @author nalin.sharma on 20/10/21
 */
public class CountWays {
    public static void main(String[] args) {
        int r = 2, c = 2;
        boolean arr [] [] = new boolean[r+1][c+1];
        int [] ways = {0};
        dfs(arr, 0, 0, ways);
        System.out.println(ways[0]);
    }

    private static void dfs(boolean[][] arr, int i, int j, int[] ways) {
        if(i == arr.length - 1 && j == arr[0].length - 1) {
            ways[0]++;
            return;
        }
        /*if(arr[i][j]) {
           return;
        }
        arr[i][j] = true;*/
        //visit neighbors
        if(i+1 <= arr.length - 1 ){ //&& !arr[i+1][j]) {
            dfs(arr,i+1, j, ways);
        }
        if(j+1 <= arr[0].length - 1){// && !arr[i][j+1]) {
            dfs(arr,i, j+1, ways);
        }
    }
}
