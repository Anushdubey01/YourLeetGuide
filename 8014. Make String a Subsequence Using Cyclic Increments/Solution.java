class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int indexStr1 = 0;
        int countMatches = 0;

        for (int i = 0; i < len2; i++) {
            char currentChar = str2.charAt(i);
            char originalChar = currentChar;
            
            // Adjust the current character if it's 'a' to handle 'z' as the previous character
            if (currentChar == 'a') {
                currentChar = 'z';
            } else {
                currentChar--;
            }

            while (indexStr1 < len1) {
                char str1Char = str1.charAt(indexStr1);
                
                // Check if the current character in str2 matches the character in str1
                if (str1Char == currentChar || str1Char == originalChar) {
                    countMatches++;
                    indexStr1++;
                    break;
                } else {
                    indexStr1++;
                }
            }
        }

        // If the count of matches equals the length of str2, return true; otherwise, return false
        return countMatches == len2;
    }
}
