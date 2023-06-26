class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
    if (nums.length == 0 || indexDiff <= 0 || valueDiff < 0)
      return false;
    final long minValue = Arrays.stream(nums).min().getAsInt();
    final long valueRange = (long) valueDiff + 1;
    HashMap<Long, Long> bucket = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      final long currentNum = (long) nums[i];
      final long key = getBucketKey(nums[i], minValue, valueRange);
      if (bucket.containsKey(key))
        return true;
      if (bucket.containsKey(key - 1) && currentNum - bucket.get(key - 1) < valueRange)
        return true;
      if (bucket.containsKey(key + 1) && bucket.get(key + 1) - currentNum < valueRange)
        return true;
      bucket.put(key, currentNum);
      if (i >= indexDiff)
        bucket.remove(getBucketKey(nums[i - indexDiff], minValue, valueRange));
    }
    return false;
  }
  private long getBucketKey(int num, long minValue, long valueRange) {
    return ((long) num - minValue) / valueRange;
  }
}