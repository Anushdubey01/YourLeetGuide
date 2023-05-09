class Solution {
    public int strongPasswordChecker(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int missing = getMissing(chars);
        int replaces = 0;
        int oneSeq = 0;
        int twoSeq = 0;

        for (int i = 2; i < n;) {
            if (chars[i] == chars[i - 1] && chars[i - 1] == chars[i - 2]) {
                int length = 2;
                while (i < n && chars[i] == chars[i - 1]) {
                    length++;
                    i++;
                }
                replaces += length / 3;
                if (length % 3 == 0)
                    oneSeq++;
                if (length % 3 == 1)
                    twoSeq++;
            } else {
                i++;
            }
        }

        if (n < 6)
            return Math.max(6 - n, missing);
        if (n <= 20)
            return Math.max(replaces, missing);

        int deletes = n - 20;
        replaces -= Math.min(oneSeq, deletes);
        replaces -= Math.min(Math.max(deletes - oneSeq, 0), twoSeq * 2) / 2;
        replaces -= Math.max(deletes - oneSeq - twoSeq * 2, 0) / 3;
        return deletes + Math.max(replaces, missing);
    }

    private int getMissing(final char[] chars) {
        int missing = 3;

        for (final char c : chars)
            if (Character.isUpperCase(c)) {
                missing--;
                break;
            }

        for (final char c : chars)
            if (Character.isLowerCase(c)) {
                missing--;
                break;
            }

        for (final char c : chars)
            if (Character.isDigit(c)) {
                missing--;
                break;
            }

        return Math.max(missing, 0);
    }
}