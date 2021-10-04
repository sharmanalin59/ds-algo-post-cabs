package algo;

import java.util.PriorityQueue;
import java.util.Queue;

public class InfiniteMedian {
    public static void main(String[] args) {
        int [] a = {4,10,1,0,0};
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a1,a2) -> a2.compareTo(a1));

        int c = -1;

        for(int i = 0; i < a.length; i++) {
            if(i == 0) {
                c = a[0];
            }
            else if(i == 1) {
                c = (a[0]+a[1])/2;
                if(a[0]<a[1]) {
                    minQ.add(a[1]);
                    maxQ.add(a[0]);
                }
                else {
                    minQ.add(a[0]);
                    maxQ.add(a[1]);
                }
            }
            else {
                int minS = minQ.size();
                int maxS = maxQ.size();
                int min = minQ.peek();
                int max = maxQ.peek();
                if (minS == maxS) {
                    if (a[i] <= max) {
                        maxQ.add(a[i]);
                    } else {
                        minQ.add(a[i]);
                    }
                } else if (maxS > minS) {
                    if (a[i] <= max) {
                        maxQ.add(a[i]);
                        minQ.add(maxQ.remove());
                    } else {
                        minQ.add(a[i]);
                    }
                } else if (maxS < minS) {
                    if (a[i] >= min) {
                        minQ.add(a[i]);
                        maxQ.add(minQ.remove());
                    } else {
                        maxQ.add(a[i]);
                    }
                }
                //find median
                if (minQ.size() == maxQ.size())
                    c = (minQ.peek() + maxQ.peek()) / 2;
                else if (minQ.size() > maxQ.size())
                    c = minQ.peek();
                else if (minQ.size() < maxQ.size())
                    c = maxQ.peek();
            }
            System.out.println(c);
        }

    }
}
