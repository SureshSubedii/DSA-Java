import java.util.*;

public class DirectedGraph {
        private Map<Integer, List<Integer>> adjList;
        private Map<Integer, Integer> inDegree;
        private Map<Integer, Integer> outDegree;


    DirectedGraph(){
            this.adjList = new HashMap<>();
            this.inDegree = new HashMap<>();
            this.outDegree = new HashMap<>();
        }
        public void addEdge(int src, int dest){
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.get(src).add(dest);

            outDegree.put(src, outDegree.getOrDefault(src, 0) + 1);
            inDegree.put(dest, inDegree.getOrDefault(dest, 0) + 1);
            inDegree.putIfAbsent(src, 0);


        }
        public void removeEdge(int src, int dest){
            if(adjList.containsKey(src)){
                adjList.get(src).remove(Integer.valueOf(dest));
                outDegree.put(src, outDegree.get(src) - 1);
                inDegree.put(dest, inDegree.get(dest) - 1);
            }
        }

        public void printGraph(){
            for(var data: adjList.entrySet()){
                System.out.println(data.getKey() + " -> " + data.getValue() + " inDegree = "  + Optional.ofNullable(this.inDegree.get(data.getKey()) ).orElse(0) +  " outDegree = "  + this.outDegree.get(data.getKey()));
            }

        }
    public void topoSortBfs(){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topoOrder = new ArrayList<>();
        for(int node: inDegree.keySet()){
            if(inDegree.get(node) == 0){
                queue.offer(node);
            }
        }
        while(!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);
            if (adjList.containsKey(node)) {

                for (int neighbour : adjList.get(node)) {
                    inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                    if (inDegree.get(neighbour) == 0) {
                        queue.offer(neighbour);
                    }

                }
            }
        }
        if (topoOrder.size() != inDegree.size()) {
            System.out.println("Graph has a cycle! Topological sorting is not possible.");
            return;
        }
        System.out.println("Topological Sort (BFS): " + topoOrder);
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
//        graph.addEdge(1, 0);
        graph.topoSortBfs();

    }
}
