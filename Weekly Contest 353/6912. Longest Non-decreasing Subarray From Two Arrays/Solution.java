class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = 1;
        dp2[0] = 1;
        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            dp1[i] = 1;
            dp2[i] = 1;

            if (nums1[i] >= nums1[i - 1]) {
                dp1[i] = dp1[i - 1] + 1;
                maxLength = Math.max(maxLength, dp1[i]);
            }

            if (nums2[i] >= nums2[i - 1]) {
                dp2[i] = dp2[i - 1] + 1;
                maxLength = Math.max(maxLength, dp2[i]);
            }

            if (nums1[i] >= nums2[i - 1]) {
                dp1[i] = Math.max(dp1[i], dp2[i - 1] + 1);
                maxLength = Math.max(maxLength, dp1[i]);
            }

            if (nums2[i] >= nums1[i - 1]) {
                dp2[i] = Math.max(dp2[i], dp1[i - 1] + 1);
                maxLength = Math.max(maxLength, dp2[i]);
            }
        }

        return maxLength;
    }
}
