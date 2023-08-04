class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True
        for i in range(1, n + 1):
            for j in range(i):
                currentWord = s[j:i]
                if dp[j] and currentWord in wordSet:
                    dp[i] = True
                    break
        return dp[n]