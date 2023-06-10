class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int i = 0, j = 1;
        int count = 0; 
        int len = 1;
        int res = 1;
        int firstCons = 0;
        while (j < s.length()){
            if (s.charAt(j) == s.charAt(j - 1)){
                count++;
                if (count == 1)
                    firstCons = j;
                if (count > 1){
                    i = firstCons;
                    firstCons = j;
                    count = 1;
                    len = j - i;
                }
            }

            len++;
            j++;
            res = Math.max(len, res);
        }

        return res;
    }
}