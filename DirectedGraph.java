import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                System.out.println(data.getKey() + " -> " + data.getValue() + " inDegree = "  + this.inDegree.get(data.getKey()) +  " outDegree = "  + this.outDegree.get(data.getKey()));
            }
        }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 0);


        graph.removeEdge(0, 1);

        graph.printGraph();





    }
}
