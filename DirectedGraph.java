import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraph {
        private Map<Integer, List<Integer>> adjList;
        DirectedGraph(){
            this.adjList = new HashMap<>();
        }
        public void addEdge(int src, int dest){
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.get(src).add(dest);
        }
        public void removeEdge(int src, int dest){
            if(adjList.containsKey(src)){
                adjList.get(src).remove(Integer.valueOf(dest));
            }
        }

        public void printGraph(){
            for(var data: adjList.entrySet()){
                System.out.println(data.getKey() + " -> " + data.getValue() + " \n");
            }
        }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);

        graph.removeEdge(0, 1);

        graph.printGraph();





    }
}
