import algo.LL;

import java.util.LinkedList;

/**
 * @author nalin.sharma on 28/09/21
 *
 * 4->2->2->7
 *
 * output: 4->2->2->8
 *
 * 4->2->9->3->9
 * 9->9
 * 4->2
 * 4  3  0  0
 */
    import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
    public class SyfePone
    {
        static class Wrapper {
            Wrapper(int i, int priority) {
                this.i = i;
                this.priority = priority;
            }
            int i, priority;
        }
        public static void main(String args[] )
        {
            // Write your code here
            Scanner s = new Scanner(System.in);
            String name = s.nextLine();             // Read input from STDIN
            String arr [] = name.split(" ");
            int len = Integer.parseInt(arr[0]);
            int size = Integer.parseInt(arr[1]);
            int missCnt = 0;

            name = s.nextLine();
            arr = name.split(" ");
            List<Integer> items = new ArrayList<>();
            for(String str: arr) {
                items.add(Integer.parseInt(str));
            }
		/*
		PriorityQueue<Wrapper> q = new PriorityQueue<>((i1,i2) -> {
			Integer.compare(i1.priority, i2.priority);
		});
		TreeSet<Integer> set = TreeSet<>();
		*/
            HashSet<Integer> set = new HashSet<>();
            LinkedList<Integer> cacheList = new LinkedList<>();
            int priority = 0, item;
            for(int i = 0; i < items.size(); i++) {
                item = items.get(i);
                if(set.contains(item)) {
                    missCnt++;
                }
                else {
                    if(set.size() == size) {
                        int removedItem = cacheList.removeFirst();
                        set.remove(removedItem);
                    }
                    set.add(item);
                    cacheList.addLast(item);
                }

            }
            System.out.println(missCnt);
            //System.out.println("Hello " + name);

        }
    }

