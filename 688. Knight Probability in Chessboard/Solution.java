class Solution {
    public double knightProbability(int n, int K, int r, int c) {
        final double kProb = 0.125;
        final int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

        double[] dp = new double[n * n];
        dp[r * n + c] = 1.0;
        for (int k = 0; k < K; ++k) {
            double[] newDp = new double[n * n];
            for (int pos = 0; pos < n * n; ++pos) {
                if (dp[pos] > 0.0) {
                    int i = pos / n;
                    int j = pos % n;
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            newDp[x * n + y] += dp[pos] * kProb;
                        }
                    }
                }
            }
            dp = newDp;
        }
        double ans = 0.0;
        for (double prob : dp) {
            ans += prob;
        }
        return ans;
    }
}