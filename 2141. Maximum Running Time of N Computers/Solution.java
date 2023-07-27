import java.util.*;
public class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int battery : batteries) {
            sum += battery;
        }
        Arrays.sort(batteries);
        for (int i = batteries.length - 1; i >= 0; i--) {
            if (batteries[i] > sum / n) {
                sum -= batteries[i];
                n--;
            }
        }
        return sum / n;
    }
}