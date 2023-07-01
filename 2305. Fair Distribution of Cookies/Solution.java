class Solution {
    int answer;
    int counter[];
    public int distributeCookies(int[] cookies, int k) {
        answer = Integer.MAX_VALUE;
        counter = new int[k];
        findMaximum(cookies, 0, k);
        return answer;
    }
    public void findMaximum(int[] cookies, int index, int k) {
        if (index == cookies.length) {
            int max = 0;
            for (int i = 0; i < k; i++) {
                max = Math.max(max, counter[i]);
            }
            answer = Math.min(answer, max);
            return;
        }
        for (int i = 0; i < k; i++) {
            counter[i] += cookies[index];
            findMaximum(cookies, index + 1, k);
            counter[i] -= cookies[index];
            if (counter[i] == 0) {
                break;
            }
        }
    }
}