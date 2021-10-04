package algo;

public class InsertionSort {
    public static void main(String[] args) {
        int arr [] = {2,1,3,2};
        if(arr.length >0) {
            for (int i = 1; i < arr.length; i++) {
                int item = arr[i];
                int j = 0;
                while(j < i && arr[j] < arr[i]) {
                    j++;
                }

                //shifting
                if(j < i){
                    int z = i-1;
                    while(z >= j) {
                        arr[z+1] = arr[z];
                        z--;
                    }
                    arr[j] = item;
                }
            }
        }
        for (int i = 0; i < arr.length;i++){
            System.out.print(" "+arr[i]);
        }
    }
}
