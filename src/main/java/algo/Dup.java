package algo;

public class Dup {
    abstract class a {
        void m(){};
    }
    abstract class b {

    }
    /*class c extends a {
        int m(){return 1;};
        char m(){return '1';};
    }*/
    public static void main(String[] args) {
        int arr [] = {3,1,3};
        int i = 0;
        for (;i < arr.length; i++) {
            int mod = Math.abs(arr[i]) - 1;
            if (arr[mod] > 0) {
                arr[mod] = -arr[mod];
            }
        }
        for (i = 0;i < arr.length; i++) {
            if(arr[i] < 0)
            System.out.println(i);
        }
    }
}
