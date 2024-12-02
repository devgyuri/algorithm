class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (checkPrefix(word, searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

    private boolean checkPrefix(String a, String b) {
        if (a.length() < b.length()) {
            return false;
        }

        for (int i = 0; i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}