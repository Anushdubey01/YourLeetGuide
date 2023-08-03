public class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        long[] ans = new long[5];
        Map<Long, Integer> count = new HashMap<>();
        for (int[] coordinate : coordinates) {
            final int x = coordinate[0];
            final int y = coordinate[1];
            for (long i = x; i < x + 2; ++i) {
                for (long j = y; j < y + 2; ++j) {
                    if (i - 1 >= 0 && i < m && j - 1 >= 0 && j < n) {
                        count.merge(i * n + j, 1, Integer::sum);
                    }
                }
            }
        }
        for (int freq : count.values()) {
            ++ans[freq];
        }
        ans[0] = (m - 1L) * (n - 1) - Arrays.stream(ans).sum();
        return ans;
    }
}