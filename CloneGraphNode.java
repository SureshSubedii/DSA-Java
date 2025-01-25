// 133. Clone Graph
class CloneGraphNode {
        private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;

        if(visited.containsKey(node)) return visited.get(node);

        Node clonedNode = new Node(node.val);
        visited.put(node, clonedNode);

        for(Node neighbor: node.neighbors){
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }

        return clonedNode;
        
    }
}
