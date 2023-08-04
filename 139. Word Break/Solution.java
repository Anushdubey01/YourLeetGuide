public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; 
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String currentWord = s.substring(j, i);
                if (dp[j] && wordSet.contains(currentWord)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}