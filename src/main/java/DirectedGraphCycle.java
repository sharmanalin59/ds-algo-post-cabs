import java.util.*;

/**
 * @author nalin.sharma on 13/10/21
 */
public class DirectedGraphCycle {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int N= 3;
        adj.add(Arrays.asList());
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList());
        adj.add(Arrays.asList(2));

        Set<Integer> visited = new HashSet<>();
        Set<Integer> cVisited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();
        int cycAt = -1;
        for(int i = 0; i < N; i++) {
            if(!visited.contains(i+1) &&
                    (cycAt = isCycle(adj, i+1, -1, visited, cVisited, parent)) != -1)
                break;
        }
        if(cycAt != -1) {
            int start = cycAt;
            System.out.println("cycle");
            while(parent.containsKey(cycAt)) {
                System.out.println(cycAt);
                cycAt = parent.get(cycAt);
                if(cycAt == start) {
                    break;
                }
            }
        }
        else {
            System.out.println("no cycle");
        }
    }

    private static int isCycle(List<List<Integer>> adj, int i, int parent,
                                   Set<Integer> visited,
                                   Set<Integer> cVisited,
                                   Map<Integer, Integer> pMap) {
        pMap.put(i, parent);
        cVisited.add(i);
        List<Integer> neighbors = adj.get(i);
        int neighbor, res;
        for(int j = 0; j < neighbors.size(); j++) {
            neighbor = neighbors.get(j);
            if(visited.contains(neighbor)) {
                continue;
            }
            if(cVisited.contains(neighbor) && parent != neighbor) {
                pMap.put(neighbor, i);
                return neighbor;
            }
            if((res = isCycle(adj, neighbor, i, visited, cVisited, pMap)) != -1) {
                return res;
            }
        }
        cVisited.remove(i);
        visited.add(i);
        return -1;
    }
}
