import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        int lenWords = words.size();
        List<String> anst = new ArrayList<>();
        String str = "";
        for (int i = 0; i < lenWords; i++) {
            String sr = words.get(i);
            int lenSr = sr.length();
            for (int j = 0; j < lenSr; j++) {
                char c = sr.charAt(j);
                if (c != separator) {
                    str += c; 
                } else {
                    if (str.length() > 0) {
                        anst.add(str);
                        str = ""; 
                    }
                }
                if (j == lenSr - 1 && str.length() > 0) {
                    anst.add(str);
                    str = ""; 
                }
            }
        }
        return anst;
    }
}