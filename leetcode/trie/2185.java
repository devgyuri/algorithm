class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.length() < pref.length()) {
                continue;
            }

            int i;
            for (i = 0; i < pref.length(); i++) {
                if (word.charAt(i) != pref.charAt(i)) {
                    break;
                }
            }
            if (i == pref.length()) {
                count++;
            }
        }
        return count;
    }
}