public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int a) {
        int b = matrix.length, c = matrix[0].length, ans = Integer.MIN_VALUE;
        long[] sum = new long[b+1]; 
        for (int i = 0; i < c; ++i) {
            long[] sumInRow = new long[b];
            for (int j = i; j < c; ++j) { 
                for (int p = 0; p < b; ++p) {
                    sumInRow[p] += matrix[p][j];
                    sum[p+1] = sum[p] + sumInRow[p];
                }
                ans = Math.max(ans, mergeSort(sum, 0, b+1, a));
                if (ans == a) return a;
            }
        }
        return ans;
    }
    int mergeSort(long[] sum, int start, int end, int a) {
        if (end == start+1) return Integer.MIN_VALUE; 
        int mid = start + (end - start)/2, cnt = 0;
        int ans = mergeSort(sum, start, mid, a);
        if (ans == a) return a;
        ans = Math.max(ans, mergeSort(sum, mid, end, a));
        if (ans == a) return a;
        long[] cache = new long[end-start];
        for (int i = start, j = mid, p = mid; i < mid; ++i) {
            while (j < end && sum[j] - sum[i] <= a) ++j;
            if (j-1 >= mid) {
                ans = Math.max(ans, (int)(sum[j-1] - sum[i]));
                if (ans == a) return a;
            }
            while (p < end && sum[p] < sum[i]) cache[cnt++] = sum[p++];
            cache[cnt++] = sum[i];
        }
        System.arraycopy(cache, 0, sum, start, cnt);
        return ans;
    }
}