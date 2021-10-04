package hackerrank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author nalin.sharma on 30/06/21
 */
public class Dikstra_HackerRank {
    static class Node {
        Node(int d, int n) {
            dis = d;
            num = n;
        }
        int dis, num;
    }
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        // Write your code here
        List<List<List<Integer>>> adj = new ArrayList<>();
        Map<Integer, Integer> sNeighbors = new HashMap<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.size(); i++) {
            List<Integer> data = edges.get(i);
            List<Integer> first = new ArrayList<>();
            first.add(data.get(1));
            first.add(data.get(2));
            adj.get(data.get(0)).add(first);
            List<Integer> sec = new ArrayList<>();
            sec.add(data.get(0));
            sec.add(data.get(2));
            adj.get(data.get(1)).add(sec);

            if(data.get(0) == s) {
                sNeighbors.put(data.get(1), data.get(2));
            }
            else if(data.get(1) == s) {
                sNeighbors.put(data.get(0), data.get(2));
            }
        }
        PriorityQueue<Node> heap = new PriorityQueue<>((n1,n2) -> Integer.compare(n1.dis, n2.dis));

        sNeighbors.forEach((k, v) -> {
            heap.add(new Node(v, k));
        });

        List<Integer> output = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            if(sNeighbors.containsKey(i)) {
                output.add(sNeighbors.get(i));
            }
            else {
                output.add(Integer.MAX_VALUE);
            }
        }


        boolean [] visited = new boolean[n+1];
        while(!heap.isEmpty()) {
            Node node = heap.remove();
            if(visited[node.num]) {
                continue;
            }
            visited[node.num] = true;
            output.set(node.num, node.dis);

            List<List<Integer>> neighbors = adj.get(node.num);
            for (List<Integer> neighbor : neighbors) {
                if (neighbor.get(0) == s) {
                    continue;
                }
                int dist = node.dis + neighbor.get(1);
                if (dist <= output.get(neighbor.get(0))) {
                    //output.set(neighbor.get(0), dist);
                    heap.add(new Node(dist, neighbor.get(0)));
                }
            }
        }
        output.replaceAll(i -> {
            if(i == Integer.MAX_VALUE) {
                return -1;
            }
            return i;
        });
        return IntStream.range(0, output.size()).filter(i -> i != s && i != 0).mapToObj(output::get).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<List<Integer>> edges =  new ArrayList<>();
        /*edges.add(Arrays.asList(1,2,24));
        edges.add(Arrays.asList(1,4,20));
        edges.add(Arrays.asList(3,1,3));
        edges.add(Arrays.asList(4,3,12));
        System.out.println(shortestReach(4, edges,1));*/

        edges.add(Arrays.asList(1,2,2));
        edges.add(Arrays.asList(1,3,4));
        edges.add(Arrays.asList(2,3,1));
        edges.add(Arrays.asList(2,4,7));
        edges.add(Arrays.asList(5,4,2));
        edges.add(Arrays.asList(3,5,3));
        edges.add(Arrays.asList(4,6,1));
        edges.add(Arrays.asList(5,6,5));
        System.out.println(shortestReach(6, edges,1));


        List<Integer> output =  new ArrayList<>();
        output.add(11);
        output.add(22);
        output.add(44);
        output.add(33);
        System.out.println(IntStream.range(0, output.size()).filter(i -> i != 0).mapToObj(output::get).collect(Collectors.toList()));
    }
}
