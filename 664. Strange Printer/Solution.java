class Solution {
    public int strangePrinter(String s) {
        final int n = s.length();
        int[][] dp = new int[n][n];
        return strangePrinter(s, 0, n - 1, dp);
    }
    private int strangePrinter(final String s, int i, int j, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] > 0)
            return dp[i][j];
        dp[i][j] = strangePrinter(s, i + 1, j, dp) + 1;
        for (int k = i + 1; k <= j; ++k) {
            if (s.charAt(k) == s.charAt(i)) {
                dp[i][j] = Math.min(dp[i][j], strangePrinter(s, i, k - 1, dp) + strangePrinter(s, k + 1, j, dp));
            }
        }
        return dp[i][j];
    }
}