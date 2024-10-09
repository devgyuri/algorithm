class Solution {
    public int minAddToMakeValid(String s) {
        int right = 0;
        int left = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        return left + right;
    }
}