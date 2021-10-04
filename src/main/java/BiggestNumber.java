import java.util.Arrays;

/**
 * @author nalin.sharma on 03/09/21
 */
public class BiggestNumber {
    public static void main(String[] args) {
        Integer a [] = {7, 70, 9};
        Arrays.sort(a, (i,j) -> {
            int ij = Integer.parseInt(i+""+j);
            int ji = Integer.parseInt(j+""+i);

            //return (ij == ji)? 0 :(ij > ji) ? -1 : 1;
            return Integer.compare(ji, ij);
        });
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"");
        }
    }
}
