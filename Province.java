// 547. Number of Provinces
class Province {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int i = 0; i < n; i ++){
            if(!visited[i]){
                provinces ++ ;
                dfs(i, isConnected, visited);

            }
        }
        return provinces;
        
    }
    public void dfs(int node, int[][] connection, boolean[] visited){
        visited[node] = true;
        for(int neighbour = 0; neighbour < connection.length; neighbour++ ){
            if(connection[node][neighbour] == 1 & !visited[neighbour]){
                dfs(neighbour, connection, visited);
            }
        }
    }
}
