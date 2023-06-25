import java.util.Arrays;

class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        Integer[][] dp = new Integer[locations.length][fuel + 1];
        return count(locations, start, finish, fuel, dp);
    }

    private static final int kMod = 1_000_000_007;

    private int count(int[] locations, int current, int finish, int fuel, Integer[][] dp) {
        if (fuel < 0)
            return 0;
        if (dp[current][fuel] != null)
            return dp[current][fuel];

        int result = (current == finish) ? 1 : 0;
        for (int next = 0; next < locations.length; ++next) {
            if (next == current)
                continue;
            result += count(locations, next, finish, fuel - Math.abs(locations[current] - locations[next]), dp);
            result %= kMod;
        }

        dp[current][fuel] = result;
        return result;
    }
}
