import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author nalin.sharma on 18/10/21
 */
public class MedianStream {
    public static void main(String[] args) {
        int arr [] = {8,2,3,1,9};
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> min = new PriorityQueue<>();
        System.out.println("mdeisan "+(arr[0]));
        if(arr[0] > arr[1]) {
            max.add(arr[1]);
            min.add(arr[0]);
        }
        else {
            max.add(arr[0]);
            min.add(arr[1]);
        }
        System.out.println("mdeisan "+(arr[0] + arr[1])/2);

        for(int i = 2; i < arr.length; i++) {
            if(max.size() == min.size()) {
                if(arr[i] > max.peek()) {
                    min.add(arr[i]);
                }
                else {
                    max.add(arr[i]);
                }
            }
            else if(max.size() > min.size()) {
                if(arr[i] < max.peek()) {
                    min.add(max.remove());
                    max.add(arr[i]);
                }
                else {
                    min.add(arr[i]);
                }
            }
            else {
                if(arr[i] > min.peek()) {
                    max.add(min.remove());
                    min.add(arr[i]);
                }
                else {
                    max.add(arr[i]);
                }
            }
            if(max.size() == min.size()) {
                System.out.println("median " + (max.peek() + min.peek()) / 2);
            }
            else if(max.size() > min.size()) {
                System.out.println("median " + max.peek());
            }
            else {
                System.out.println("median " + min.peek());
            }
        }
    }
}
