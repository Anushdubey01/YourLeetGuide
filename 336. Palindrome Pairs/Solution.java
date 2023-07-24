class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            dict.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (dict.containsKey("") && dict.get("") != i && word.equals(new StringBuilder(word).reverse().toString())) {
                ans.add(Arrays.asList(i, dict.get("")));
            }
            for (int j = 1; j <= word.length(); j++) {
                String l = word.substring(0, j);
                String r = word.substring(j);
                if (dict.containsKey(l) && dict.get(l) != i && r.equals(new StringBuilder(r).reverse().toString())) {
                    ans.add(Arrays.asList(i, dict.get(l)));
                }
                if (dict.containsKey(r) && dict.get(r) != i && l.equals(new StringBuilder(l).reverse().toString())) {
                    ans.add(Arrays.asList(dict.get(r), i));
                }
            }
        }
        return ans;
    }
}