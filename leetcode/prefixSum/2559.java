class Solution {
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int m = queries.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            String word = words[i - 1];
            prefixSum[i] = prefixSum[i - 1];
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                prefixSum[i]++;
            }
        }

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            ans[i] = prefixSum[query[1] + 1] - prefixSum[query[0]];
        }
        return ans;
    }
}