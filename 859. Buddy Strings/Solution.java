public class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.equals(B) && hasDuplicateCharacters(A)) {
            return true;
        }

        int diffCount = 0;
        int[] diffIndices = new int[2];
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (diffCount == 2) {
                    return false;
                }
                diffIndices[diffCount] = i;
                diffCount++;
            }
        }

        return diffCount == 2 && A.charAt(diffIndices[0]) == B.charAt(diffIndices[1]) && A.charAt(diffIndices[1]) == B.charAt(diffIndices[0]);
    }

    private boolean hasDuplicateCharacters(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            if (count[c - 'a']++ > 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String A = "abc";
        String B = "abd";
        System.out.println(solution.buddyStrings(A, B));
    }
}
