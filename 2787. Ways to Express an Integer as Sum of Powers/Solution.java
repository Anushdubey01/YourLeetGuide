public class Solution {
    public int numberOfWays(int n, int x) {
        final int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        int ax;
        dp[0] = 1;
        for (int a = 1; (ax = (int) Math.pow(a, x)) <= n; ++a) {
            for (int i = n; i >= ax; --i) {
                dp[i] += dp[i - ax];
                dp[i] %= MOD;
            }
        }
        return dp[n];
    }
}