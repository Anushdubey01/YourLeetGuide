class Solution:
    def strangePrinter(self, s: str) -> int:
        if not s:
            return 0
        n = len(s)
        dp = [[n for _ in range(n)] for _ in range(n)]
        for i in range(n):
            dp[i][i] = 1
        for j in range(n):
            for i in range(j, -1, -1):
                for k in range(i, j):
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j] - (1 if s[k] == s[j] else 0))
        return dp[0][n - 1]