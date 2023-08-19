import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        List<Integer> temp = new ArrayList<>();
        int count = 0;

        temp.add(nums.get(0));

        for (int i = 1; i < n; i++) {
            int num = nums.get(i);
            int lo = lowerBound(temp, num);
            int up = upperBound(temp, num);

            if (up == temp.size()) {
                temp.add(num);
            } else {
                int ind = up;
                temp.set(ind, Math.min(temp.get(ind), num));
                count++;
            }
        }

        return count;
    }

    private int lowerBound(List<Integer> list, int num) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < num) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int upperBound(List<Integer> list, int num) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= num) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
