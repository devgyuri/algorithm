class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPrefixAndSuffix(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return false;
        }

        int n = str1.length();
        int m = str2.length();
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != str2.charAt(i) || str1.charAt(i) != str2.charAt(m - n + i)) {
                return false;
            }
        }
        return true;
    }
}