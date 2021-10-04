package algo;

public class ArrayJump2 {

    public static void main(String[] args) {
        int arr [] = {6,4,2,2,2,2,1};
        int T[] = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            int min = -1;
            for (int j = 0; j < i; j++) {
                if(arr[0] >= i) {
                    T[i] = 1;
                    break;
                }
                else if(arr[j] >= i - j) {
                    if(min == -1 || min > T[j] + 1) {
                        min = T[j] + 1;
                    }
                }
                T[i] = min;
            }
        }
        System.out.println(T[T.length - 1]);
    }
}
