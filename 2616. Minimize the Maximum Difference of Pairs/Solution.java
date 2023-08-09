class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            final int middle = (left + right) / 2;
            if (countPairs(nums, middle) >= p)
                right = middle;
            else
                left = middle + 1;
        }
        return left;
    }
    private int countPairs(int[] nums, int maxDiff) {
        int count = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                ++count;
                ++i; 
            }
        }
        return count;
    }
}