class Solution {
    public boolean isAcronym(List<String> words, String s) {
        // Check if the length of s is not equal to the number of words
        if (s.length() != words.size()) {
            return false;
        }

        // Iterate through words and compare the first character with s
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            char firstCharOfWord = word.charAt(0);
            char charInS = s.charAt(i);
            
            if (firstCharOfWord != charInS) {
                return false;
            }
        }

        // If all characters match, s is an acronym of words
        return true;
    }
}
