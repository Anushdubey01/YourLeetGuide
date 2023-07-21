import java.util.*;
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            int maxLen = 0;
            int c = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j] > maxLen) {
                        maxLen = length[j];
                        c = count[j];
                    } else if (length[j] == maxLen) {
                        c += count[j];
                    }
                }
            }
            length[i] = maxLen + 1;
            count[i] = c;
            maxLength = Math.max(maxLength, length[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                ans += count[i];
            }
        }
        return ans;
    }
}