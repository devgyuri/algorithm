class Solution {
    public String compressedString(String word) {
        char prev = word.charAt(0);
        int count = 1;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c != prev || count == 9) {
                ans.append(Integer.toString(count));
                ans.append(prev);
                prev = c;
                count = 1;
            } else {
                count++;
            }
        }
        ans.append(Integer.toString(count));
        ans.append(prev);
        return ans.toString();
    }
}