import java.util.Arrays;
public class Solution {
    public int triangleNumber(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        for (int c = nums.length - 1; c > 1; c--) {
            int a = 0;
            int b = c - 1;
            while (a < b) {
                if (nums[a] + nums[b] > nums[c]) {
                    answer += b - a;
                    b--;
                } else {
                    a++;
                }
            }
        }
        return answer;
    }
}