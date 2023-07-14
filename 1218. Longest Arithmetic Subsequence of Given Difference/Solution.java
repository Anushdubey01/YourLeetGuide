class Solution {
  public int longestSubsequence(int[] arr, int diff) {
    int answer = 0;
    Map<Integer, Integer> lengthAt = new HashMap<>();
    for (final int a : arr) {
      lengthAt.put(a, lengthAt.getOrDefault(a - diff, 0) + 1);
      answer = Math.max(answer, lengthAt.get(a));
    }
    return answer;
  }
}