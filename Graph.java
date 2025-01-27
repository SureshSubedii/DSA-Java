import java.util.*;

public class Graph {
    Map<Integer, Node> nodes = new HashMap<>();

    class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("val = ").append(val).append(", neighbors = [");
            for (Node neighbor : neighbors) {
                sb.append(neighbor.val).append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public void addVertex(int vertex) {
        nodes.putIfAbsent(vertex, new Node(vertex));
    }

    public void addEdge(int first, int second) {
        nodes.putIfAbsent(first, new Node(first));
        nodes.putIfAbsent(second, new Node(second));
        Node node1 = nodes.get(first);
        Node node2 = nodes.get(second);

        if (!node1.neighbors.contains(node2)) {
            node1.neighbors.add(node2);
        }
        if (!node2.neighbors.contains(node1)) {
            node2.neighbors.add(node1);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes.values()) {
            sb.append(node).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(1, 4);

        System.out.println(graph);
    }
}
