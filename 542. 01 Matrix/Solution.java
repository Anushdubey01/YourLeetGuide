public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        final int[] directions = {0, 1, 0, -1, 0};
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            final int row = queue.peek()[0];
            final int col = queue.poll()[1];
            for (int k = 0; k < 4; ++k) {
                final int newRow = row + directions[k];
                final int newCol = col + directions[k + 1];
                if (newRow < 0 || newRow == rows || newCol < 0 || newCol == cols)
                    continue;
                if (visited[newRow][newCol])
                    continue;
                matrix[newRow][newCol] = matrix[row][col] + 1;
                queue.offer(new int[] {newRow, newCol});
                visited[newRow][newCol] = true;
            }
        }

        return matrix;
    }
}