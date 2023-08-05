class Solution {
    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            frequencyMap.putIfAbsent(num, new ArrayList<>());
            frequencyMap.get(num).add(i);
        }

        int result = Integer.MAX_VALUE;
        for (List<Integer> indices : frequencyMap.values()) {
            int maxDistance = indices.get(0) + nums.size() - indices.get(indices.size() - 1) - 1;
            for (int i = 0; i < indices.size() - 1; i++) {
                int diffIndex = indices.get(i + 1) - indices.get(i) - 1;
                maxDistance = Math.max(maxDistance, diffIndex);
            }
            maxDistance = (int) Math.ceil((double) maxDistance / 2);
            result = Math.min(result, maxDistance);
        }
        return result;
    }
}
