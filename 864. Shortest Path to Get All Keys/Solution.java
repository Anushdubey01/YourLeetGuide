class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int allKeys = 0;
        int startRow = -1;
        int startCol = -1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startRow = i;
                    startCol = j;
                } else if (c >= 'a' && c <= 'f') {
                    allKeys |= (1 << (c - 'a'));
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][64];
        queue.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol][0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                int keys = curr[2];
                if (keys == allKeys) {
                    return steps;
                }
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                        char cell = grid[newRow].charAt(newCol);
                        if (cell == '#') {
                            continue;
                        }
                        int newKeys = keys;
                        if (cell >= 'a' && cell <= 'f') {
                            newKeys |= (1 << (cell - 'a'));
                        }
                        if (cell >= 'A' && cell <= 'F' && (keys & (1 << (cell - 'A'))) == 0) {
                            continue;
                        }
                        if (!visited[newRow][newCol][newKeys]) {
                            queue.offer(new int[]{newRow, newCol, newKeys});
                            visited[newRow][newCol][newKeys] = true;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}