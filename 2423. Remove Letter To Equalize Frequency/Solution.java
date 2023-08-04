public class Solution {
    public boolean equalFrequency(String word) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : word.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            count.put(c, count.get(c) - 1);
            if (areAllFrequenciesEqual(count)) {
                return true;
            }
            count.put(c, count.get(c) + 1);
        }
        return false;
    }
    private boolean areAllFrequenciesEqual(HashMap<Character, Integer> count) {
        int freq = -1;
        for (int c : count.values()) {
            if (c == 0 || c == freq) {
                continue;
            }
            if (freq == -1) {
                freq = c;
            } else {
                return false;
            }
        }
        return true;
    }
}