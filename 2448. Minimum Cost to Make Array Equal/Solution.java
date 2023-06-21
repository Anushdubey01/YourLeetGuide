import java.util.Arrays;
class Solution {
    public long minCost(int[] nums, int[] cost) {
        long minimumCost = 0;
        int lowestNum = Arrays.stream(nums).min().getAsInt();
        int highestNum = Arrays.stream(nums).max().getAsInt();
        while (lowestNum < highestNum) {
            final int mid = (lowestNum + highestNum) / 2;
            final long cost1 = calculateCost(nums, cost, mid);
            final long cost2 = calculateCost(nums, cost, mid + 1);
            minimumCost = Math.min(cost1, cost2);
            if (cost1 < cost2)
                highestNum = mid;
            else
                lowestNum = mid + 1;
        }
        return minimumCost;
    }
    private long calculateCost(int[] nums, int[] cost, int target) {
        long totalCost = 0;

        for (int i = 0; i < nums.length; ++i)
            totalCost += Math.abs(nums[i] - target) * (long) cost[i];

        return totalCost;
    }
}