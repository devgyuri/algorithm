class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordMap = new HashMap<>();

        parseString(s1, wordMap);
        parseString(s2, wordMap);

        List<String> ansList = new ArrayList<>();
        for (String word: wordMap.keySet()) {
            if (wordMap.get(word) == 1) {
                ansList.add(word);
            }
        }
        
        String[] ans = new String[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    private void parseString(String s, Map<String, Integer> map) {
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            if (s.charAt(end) == ' ') {
                String word = s.substring(start, end);
                map.put(word, map.getOrDefault(word, 0) + 1);
                start = end + 1;
            }
            end++;
        }
        String word = s.substring(start);
        map.put(word, map.getOrDefault(word, 0) + 1);
    }
}