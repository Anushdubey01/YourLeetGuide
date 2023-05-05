public class MaxVowels {
    public int maxVowels(String s, int k) {
        String firstString = s.substring(0, k);
        char[] array = s.toCharArray();
        int count = (int) firstString.chars().filter(c -> "aeiouAEIOU".indexOf(c) >= 0).count();
        int res = count;
        for (int i = k; i < s.length(); i++) {
            if ("aeiouAEIOU".indexOf(array[i]) >= 0) {
                count++;
            }
            if ("aeiouAEIOU".indexOf(array[i-k]) >= 0) {
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}