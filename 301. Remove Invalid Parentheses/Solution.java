import java.util.*;
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> validExpressions = new ArrayList<>();
        int[] counts = getLeftAndRightCounts(s);
        dfs(s, 0, counts[0], counts[1], validExpressions);
        return validExpressions;
    }
    private int[] getLeftAndRightCounts(final String s) {
        int leftCount = 0;
        int rightCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                ++leftCount;
            else if (c == ')') {
                if (leftCount == 0)
                    ++rightCount;
                else
                    --leftCount;
            }
        }
        return new int[] { leftCount, rightCount };
    }
    private void dfs(final String s, int start, int leftCount, int rightCount, List<String> validExpressions) {
        if (leftCount == 0 && rightCount == 0 && isValid(s)) {
            validExpressions.add(s);
            return;
        }
        for (int i = start; i < s.length(); ++i) {
            if (i > start && s.charAt(i) == s.charAt(i - 1))
                continue;
            if (leftCount > 0 && s.charAt(i) == '(')
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount - 1, rightCount, validExpressions);
            else if (rightCount > 0 && s.charAt(i) == ')')
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount, rightCount - 1, validExpressions);
        }
    }
    private boolean isValid(final String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                ++count;
            else if (c == ')')
                --count;
            if (count < 0)
                return false;
        }
        return count == 0;
    }
}