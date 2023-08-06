class Solution:
    def numMusicPlaylists(self, n: int, goal: int, k: int) -> int:
        kMod = 1_000_000_007
        dp = [[0 for _ in range(n + 1)] for _ in range(goal + 1)]
        dp[0][0] = 1
        for i in range(1, goal + 1):
            for j in range(1, n + 1):
                dp[i][j] += dp[i - 1][j - 1] * (n - (j - 1))  # Last song is new
                dp[i][j] += dp[i - 1][j] * max(0, j - k)  # Last song is old
                dp[i][j] %= kMod
        return int(dp[goal][n])