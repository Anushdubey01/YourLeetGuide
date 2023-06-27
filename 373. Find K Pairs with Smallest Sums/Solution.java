import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
class Pair {
    public int index1;
    public int index2;
    public int sum;
    public Pair(int index1, int index2, int sum) {
        this.index1 = index1;
        this.index2 = index2;
        this.sum = sum;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        for (int i = 0; i < k && i < nums1.length; ++i)
            minHeap.offer(new Pair(i, 0, nums1[i] + nums2[0]));
        while (!minHeap.isEmpty() && result.size() < k) {
            final int index1 = minHeap.peek().index1;
            final int index2 = minHeap.poll().index2;
            result.add(Arrays.asList(nums1[index1], nums2[index2]));

            if (index2 + 1 < nums2.length)
                minHeap.offer(new Pair(index1, index2 + 1, nums1[index1] + nums2[index2 + 1]));
        }
        return result;
    }
}