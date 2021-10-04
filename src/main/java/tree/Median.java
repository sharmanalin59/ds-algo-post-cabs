package tree;

import edu.emory.mathcs.backport.java.util.Collections;

import java.util.PriorityQueue;

/**
 * @author nalin.sharma on 23/06/21
 */
public class Median {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        int arr [] = {94455,20555,20535,53125,73634,148,63772,17738,62995,13401,95912,13449,92211,17073,69230,22016,22120};
        //int arr [] = {1,2,3,5,4};
        //int arr [] = {1,2,3,4,5,6,7,8,9,10};
        //System.out.println("array " + arr[0]);
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                maxQ.add(arr[0]);
                System.out.println("median "+ arr[0]);
                continue;
            }
            if(maxQ.size() == minQ.size()) {
                if(arr[i] > minQ.peek()) {
                    minQ.add(arr[i]);
                }
                else {
                    maxQ.add(arr[i]);
                }
            }
            else if(maxQ.size() > minQ.size()) {
                if(arr[i] >= maxQ.peek()) {
                    minQ.add(arr[i]);
                }
                else {
                    maxQ.add(arr[i]);
                    minQ.add(maxQ.remove());
                }
            }
            else {
                if(arr[i] <= maxQ.peek()) {
                    maxQ.add(arr[i]);
                }
                else {
                    minQ.add(arr[i]);
                    maxQ.add(minQ.remove());
                }
            }
            System.out.println("median "+show(maxQ, minQ));

        }
    }

    private static double show(PriorityQueue<Integer> maxQ, PriorityQueue<Integer> minQ) {
        if(maxQ.size() == minQ.size()) {
            return (minQ.peek() + maxQ.peek()) /2.0;
        }
        if(maxQ.size() > minQ.size()) {
            return maxQ.peek();
        }
        return minQ.peek();
    }
}
