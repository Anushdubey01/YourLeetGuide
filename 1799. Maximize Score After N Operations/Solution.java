import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> lookup = new HashMap<>();

    int dp(int a, int mask, int[] nums, int m) {
        if (mask == 0) return 0;
        int key = a + mask * 10;
        if (!lookup.containsKey(key)) {
            int maxVal = 0;
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int j = i + 1; j < m; j++) {
                        if ((mask & (1 << j)) != 0) {
                            maxVal = Math.max(maxVal, a * gcd(nums[i], nums[j]) +
                                    dp(a + 1, mask ^ (1 << i) ^ (1 << j), nums, m));
                        }
                    }
                }
            }
            lookup.put(key, maxVal);
        }
        return lookup.get(key);
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    int maxScore(int[] nums) {
        int m = nums.length;
        return dp(1, (1 << m) - 1, nums, m);
    }
}
