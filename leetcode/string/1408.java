class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> dictionary = new HashSet<>();
        for (String word : words) {
            dictionary.add(word);
        }

        for (String word : words) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j <= len; j++) {
                    String newWord = word.substring(i, j);
                    if (dictionary.contains(newWord) && !word.equals(newWord)) {
                        ans.add(newWord);
                        dictionary.remove(newWord);
                    }
                }
            }
        }
        return ans;
    }
}