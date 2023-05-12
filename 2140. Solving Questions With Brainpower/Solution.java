class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        List<List<Integer>> questionList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> question = new ArrayList<>();
            question.add(questions[i][0]);
            question.add(questions[i][1]);
            questionList.add(question);
        }
        
        long[] r = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            int b = questionList.get(i).get(1);
            int p = questionList.get(i).get(0);
            if (i == n - 1) {
                r[i] = p;
            } else if (i + b + 1 >= n) {
                r[i] = r[i + 1];
                if (p > r[i]) {
                    r[i] = p;
                }
            } else {
                r[i] = r[i + 1];
                if (r[i] < p + r[i + b + 1]) {
                    r[i] = p + r[i + b + 1];
                }
            }
        }
        return r[0];
    }
}
