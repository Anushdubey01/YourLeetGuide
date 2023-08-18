class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int ans = 0;
        HashSet<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }
        for (int[] road : roads) {
            int city1 = road[0];
            int city2 = road[1];
            adj[city1].add(city2);
            adj[city2].add(city1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = adj[i].size() + adj[j].size();
                if (adj[i].contains(j)) {
                    tmp--;
                }
                ans = Math.max(ans, tmp);
            }
        }
        return ans;
    }
}