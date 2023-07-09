class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        
        for (int i = 0; i < n - k + 1; i++) {
            if (nums[i] > 0) {
                int min = nums[i];
                for (int j = i; j < i + k; j++) {
                    nums[j] -= min;
                }
            }
        }
        
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        
        return true;
    }
}
