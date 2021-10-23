/**
 * @author nalin.sharma on 18/10/21
 */
public class MissingAndRepeating {
    public static void main(String[] args) {
        int arr [] = {6,7,1,4,3,5,4};
        int N = 7;
        for(int i = 0; i < arr.length; i++) {
            int ind = Math.abs(arr[i]) - 1;
            if(arr[ind] > 0)
            arr[ind] = -arr[ind];
            else
                System.out.println("repeat "+(ind+1));
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                System.out.println("missing "+(i+1));
                break;
            }
        }
        //System.out.print("\n"+r+" "+m);
    }
}
