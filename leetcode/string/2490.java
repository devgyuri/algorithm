class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String curr = words[i % n];
            String next = words[(i + 1) % n];
            if (curr.charAt(curr.length() - 1) != next.charAt(0)) {
                return false;
            }
        }
        return true;
    }
}