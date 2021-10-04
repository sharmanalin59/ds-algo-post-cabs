package graph;

import java.util.*;

public class Dijkstra {

    /*
     *
     * @author nalin.sharma
     *
     */

    /**
     *
     * Heap Map Data Structure
     * Heap stores the Nodes with their weight based on comparison on Node's weight
     * HashMap stores the Node and its index for O(1) look up of node in heap
     *
     *
     *
     *
     * Example -:
     *
     *                                   7
     *                         [2]----------------->[4]
     *                       ^  |                   ^ \
     *                     /   |                   |   \ 1
     *                 2 /    |                   |     v
     *                 /     |                   |       [6]
     *               /      | 1               2 |       ^
     *             /       |                   |      /
     *          [1]       |                   |     /
     *             \     |                   |    / 5
     *            4 \   |                   |   /
     *               v v                   |  /
     *                [3]---------------->[5]
     *                         3
     *
     *        Minimum distance from source 1
     *         v  | d[v] | path
     *         --- ------  ---------
     *         2 |  2  |  1,2
     *         3 |  3  |  1,2,3
     *         4 |  8  |  1,2,3,5,4
     *         5 |  6  |  1,2,3,5
     *         6 |  9  |  1,2,3,4,6
     *
     *
     *
     *     Below is the Implementation -:
     *
     */

    static class HeapMap<T> {
        int size, ind = 0;
        NodeWeight<T> arr [];
        Map<T,Integer> map;

        /**
         *
         * @param t is the Node(1,2,3..or A,B,C.. )
         * @return the index of element in min heap
         */
        int index(T t) {
            return map.get(t);
        }

        /**
         *
         * @param index is the Node(1,2,3..or A,B,C.. )
         * @return Node and its Weight
         */
        NodeWeight<T> node(int index) {
            return arr[index];
        }

        /**
         *
         * @param <T> Node of type <T> and its weight
         */
        static class NodeWeight<T> {
            NodeWeight(T v, int w) {
                nodeVal = v;
                weight = w;
            }
            T nodeVal;
            int weight;
            List<T> path = new ArrayList<>();
        }

        public HeapMap(int s) {
            size = s;
            arr = new NodeWeight[size + 1];
            map = new HashMap<>();
        }

        private void updateIndex(T key, int newInd) {
            map.put(key, newInd);
        }

        private void shiftUp(int i) {
            while(i > 1) {
                int par = i / 2;
                NodeWeight<T> currNodeWeight = arr[i];
                NodeWeight<T> parentNodeWeight = arr[par];
                if(parentNodeWeight.weight > currNodeWeight.weight) {
                    updateIndex(parentNodeWeight.nodeVal, i);
                    updateIndex(currNodeWeight.nodeVal, par);
                    swap(par,i);
                    i = i/2;
                }
                else {
                    break;
                }
            }
        }

        /**
         *
         * @param nodeVal
         * @param newWeight
         * Based on if the value introduced is higher or lower shift down or shift up operations are performed
         *
         */
        public void update(T nodeVal, int newWeight) {
            int i = ind;
            NodeWeight<T> nodeWeight = arr[map.get(nodeVal)];
            int oldWt = nodeWeight.weight;
            nodeWeight.weight = newWeight;
            if(oldWt < newWeight) {
                shiftDown(map.get(nodeVal));
            }
            else if(oldWt > newWeight) {
                shiftUp(map.get(nodeVal));
            }
        }

        /**
         *
         * @param nodeVal
         * @param wt
         *
         * Typical insertion in Min Heap and storing its element's indices in HashMap for fast lookup
         */
        public void insert(T nodeVal, int wt) {
            NodeWeight<T> nodeWt = new NodeWeight<>(nodeVal, wt);
            arr[++ind] = nodeWt;
            updateIndex(nodeVal, ind);
            shiftUp(ind);
        }

        private void swap(int i, int j) {
            NodeWeight<T> tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        private void shiftDown(int i) {
            while(i <= ind) {
                int current = i;
                int lChild = i * 2;
                int rChild = i * 2 + 1;
                if(rChild <= ind) {
                    int childInd = (arr[lChild].weight < arr[rChild].weight) ? lChild : rChild;
                    if(arr[childInd].weight < arr[i].weight) {
                        updateIndex(arr[childInd].nodeVal, i);
                        updateIndex(arr[i].nodeVal, childInd);
                        swap(childInd, i);
                        i = childInd;
                    }
                }
                else if(lChild <= ind && arr[lChild].weight < arr[i].weight) {
                    updateIndex(arr[lChild].nodeVal, i);
                    updateIndex(arr[i].nodeVal, lChild);
                    swap(lChild, i);
                    i = lChild;
                }
                if(current == i) {
                    break;
                }
            }
        }

        /**
         *
         * @return
         *
         * Typical deletion in Min Heap and removing its element's indices in HashMap
         *
         */
        public NodeWeight<T> remove() {
            if(ind == 0) {
                return null;
            }
            map.remove(arr[1].nodeVal);
            NodeWeight<T> out = arr[1];
            out.path.add(arr[1].nodeVal);
            arr[1] = arr[ind];
            arr[ind--] = null;
            if(ind > 0) {
                updateIndex(arr[1].nodeVal, 1);
                shiftDown(1);
            }
            return out;
        }
    }

    /**
     *
     *  Graph representation -: It is an Map(T,Node<T>) of Map(T(neighbour), Integer(Edge's weight))
     *
     */
    static class Graph<T> {

        void init(T... t) {
            for(T z: t) {
                nodes.put(z, new Node<>(z));
            }
        }

        public Graph(int s, T... t) {
            size = s;
            nodes = new LinkedHashMap<>(size);
            init(t);
        }

        /**
         *
         * Node class
         *
         */
        static class Node<T> {
            Node(T v) {
                val = v;
            }
            T val;
            //Set<Edge> edges = new HashSet<>();
            Map<T, Integer> edges = new HashMap<>();
        }

        /*static class Edge {
            Edge(int to, int w) {
                target = to;
                wt = w;
            }
            int target;
            int wt;
            }
        }*/

        int size;

        Map<T, Node<T>> nodes;

        void addEdge(T from, T to, int wt) {
            nodes.get(from).edges.put(to, wt);
        }
    }

    /**
     *
     * @param graph
     * @param from
     * @param heapMap
     * @param <T>
     *
     * Performs initialisation of all the nodes from the start vertex
     *
     */
        private static <T> void init(Graph<T> graph, T from, HeapMap<T> heapMap) {
        Graph.Node<T> fromNode = graph.nodes.get(from);
        graph.nodes.forEach((k,v)-> {
                if(from != k) {
                    heapMap.insert(k, fromNode.edges.getOrDefault(k, Integer.MAX_VALUE));
                }
            });
        }


    static class NodePathMinWeight<T> {
        NodePathMinWeight(T n, List<T> p, int c) {
            node = n;
            path = p;
            minCost= c;
        }
        T node;
        List<T> path;
        int minCost;
    }

    /**
     *
     * @param graph
     * @param from
     * @param <T>
     * @return
     *
     * Repeat the below process for all the vertices-:
     * Greedy way of picking the current shortest distance and updating its neighbors distance via this vertex
     *
     * Since Each Vertex V has E edges, the time Complexity is
     *
     * O(V.logV.E)
     * 1. selecting vertex with shortest distance from source in logV time -> O(logV) via Heap Map Data structure
     * 2. Visiting all E edges of this vertex and updating the path of its neighbors if found less via this this vertex. -> O(E)
     * 3. Doing operation step 1 and step 2 for all the vertices -> O(V)
     *
     */

        static <T> Map<T,NodePathMinWeight<T>> dijkstra(Graph<T> graph, T from) {
        Map<T,NodePathMinWeight<T>> output = new HashMap<>();
        HeapMap<T> heapMap = new HeapMap<>(graph.nodes.size());
        init(graph, from, heapMap);
        Set<T> isNotVisited = new HashSet<>();
        graph.nodes.forEach((k,v) -> isNotVisited.add(k));
        isNotVisited.remove(from);
        while(!isNotVisited.isEmpty()) {
            HeapMap.NodeWeight<T> currNodeWeight = heapMap.remove();
            output.put(currNodeWeight.nodeVal,
                    new NodePathMinWeight<>(currNodeWeight.nodeVal, currNodeWeight.path, currNodeWeight.weight));
            //mark visited
            isNotVisited.remove(currNodeWeight.nodeVal);
            //neighbors
            Map<T, Integer> neighbors = graph.nodes.get(currNodeWeight.nodeVal).edges;
            neighbors.forEach((k,v) -> {
                int ind = heapMap.index(k);
                HeapMap.NodeWeight<T> neighbor = heapMap.node(ind);
                int neighborDist = neighbor.weight;
                int currentDistance = currNodeWeight.weight;
                if(currentDistance + v < neighborDist) {
                    //update
                    neighbor.path = new ArrayList<>(currNodeWeight.path);
                    heapMap.update(neighbor.nodeVal, currentDistance + v);
                }
            });
        }
        return output;
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(6,1,2,3,4,5,6);
        graph.addEdge(1,2,2);
        graph.addEdge(1,3,4);
        graph.addEdge(2,3,1);
        graph.addEdge(2,4,7);
        graph.addEdge(3,5,3);
        graph.addEdge(5,6,5);
        graph.addEdge(4,6,1);
        graph.addEdge(5,4,2);

        Integer source = 1;
        Map<Integer,NodePathMinWeight<Integer>> map = dijkstra(graph,source);
        map.forEach((k,v) -> {
            v.path.add(0,source);
            System.out.println("source vertex :["+source+"] to vertex :["+k+"] cost:"+v.minCost+
                    " shortest path :"+v.path);
        });
    }
}
