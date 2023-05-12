public class Solution {
    private class Node implements Comparable<Node>{
        public int x;
        public int y;
        public int h;
        public Node(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
        public int compareTo(Node n) {
            return this.h - n.h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int[][] hm = heightMap;
        if (hm == null || hm.length == 0 || hm[0].length == 0) {
            return 0;
        }
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        int m = hm.length, n = hm[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i ++) {
            q.add(new Node(i, 0, hm[i][0]));
            q.add(new Node(i, n - 1, hm[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j ++) {
            q.add(new Node(0, j, hm[0][j]));
            q.add(new Node(m - 1, j, hm[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        int level = Integer.MIN_VALUE;
        int water = 0;
        int[][] dir = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x, y = node.y, h = node.h;
            if (h < level) {
                water += level - h;
            }
            level = Math.max(level, h);
            for (int k = 0; k < dir.length; k ++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (visited[nx][ny] == true) {
                    continue;
                }
                q.add(new Node(nx, ny, hm[nx][ny]));
                visited[nx][ny] = true;
            }
        }
        return water;
    }
}