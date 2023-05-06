class Solution2 {
    private int answer = 0; // declare the variable answer here

    public int uniquePathsIII(int[][] grid) {
        int emptyCount = 1;
        int startX = -1;
        int startY = -1;
        int endX = -1;
        int endY = -1;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0) {
                    ++emptyCount;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 2) {
                    endX = i;
                    endY = j;
                }
            }
        }

        depthFirstSearch(grid, emptyCount, startX, startY, endX, endY);

        return answer;
    }

    private void depthFirstSearch(int[][] grid, int emptyCount, int i, int j, int endX, int endY) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
            return;

        if (grid[i][j] < 0)
            return;

        if (i == endX && j == endY) {
            if (emptyCount == 0)
                ++answer;
            return;
        }

        grid[i][j] = -2;

        depthFirstSearch(grid, emptyCount - 1, i + 1, j, endX, endY);
        depthFirstSearch(grid, emptyCount - 1, i - 1, j, endX, endY);
        depthFirstSearch(grid, emptyCount - 1, i, j + 1, endX, endY);
        depthFirstSearch(grid, emptyCount - 1, i, j - 1, endX, endY);

        grid[i][j] = 0;
    }
}
