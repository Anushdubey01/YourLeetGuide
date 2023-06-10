import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isFascinating(int n) {
        String concatenated = String.valueOf(n) + String.valueOf(2 * n) + String.valueOf(3 * n);
        if (concatenated.length() != 9)
            return false;
        
        Set<Character> digits = new HashSet<>();
        for (char ch : concatenated.toCharArray()) {
            if (ch == '0')
                return false;
            digits.add(ch);
        }
        
        for (int i = 1; i <= 9; ++i) {
            if (!digits.contains((char) ('0' + i)))
                return false;
        }
        
        return true;
    }
}
