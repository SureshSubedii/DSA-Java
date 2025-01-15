import java.util.LinkedList;
import java.util.Queue;

class Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = new int[][] {
                { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } 
        };

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
                    result[newX][newY] = result[x][y] + 1; 
                    queue.add(new int[] { newX, newY });
                    visited[newX][newY] = true;
                }
            }
        }

        return result;
    }
}
