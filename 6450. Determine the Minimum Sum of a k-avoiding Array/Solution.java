class Solution {
    public int minimumSum(int n, int k) {
        Set<Integer> st = new HashSet<>();
        List<Integer> v = new ArrayList<>();
        int now = 1;

        while (v.size() < n) {
            if (!st.contains(now)) {
                v.add(now);
                st.add(k - now);
            }
            now++;
        }

        int sum = v.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }
}
