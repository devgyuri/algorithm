class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        int len1 = sentence1.length();
        int len2 = sentence2.length();
        if (len1 > len2) {
            return areSentencesSimilar(sentence2, sentence1);
        } else if (len1 == len2) {
            return sentence1.equals(sentence2);
        }

        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int p1 = 0, p2 = 0;
        boolean matchFlag = false;
        while (p1 < words1.length && p2 < words2.length) {
            if (words1[p1].equals(words2[p2])) {
                p1++;
                p2++;
            } else {
                if (matchFlag) {
                    return false;
                }
                while (p2 < words2.length && !words1[p1].equals(words2[p2])) {
                    p2++;
                }
                matchFlag = true;
            }
        }
        return p1 == words1.length && (p2 == p1 || p2 == words2.length);
    }
}