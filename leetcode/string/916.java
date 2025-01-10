class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n = words1.length;
        int m = words2.length;
        int[][] charCount = new int[n][26];
        for (int i = 0; i < n; i++) {
            String word = words1[i];
            for (char c : word.toCharArray()) {
                charCount[i][c - 'a']++;
            }
        }

        boolean[] isValid = new boolean[n];
        Arrays.fill(isValid, true);
        for (String word : words2) {
            int[] currCount = new int[26];
            for (char c : word.toCharArray()) {
                currCount[c - 'a']++;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 26; j++) {
                    if (isValid[i] && currCount[j] > charCount[i][j]) {
                        isValid[i] = false;
                    }
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isValid[i]) {
                ans.add(words1[i]);
            }
        }
        return ans;
    }
}