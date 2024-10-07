class Solution {
    public int minLength(String s) {
        int n = s.length();
        int i = 0;
        while (i < s.length()) {
            s = removeSubstring(s, i);
            i++;
        }
        return s.length();
    }

    private String removeSubstring(String s, int i) {
        if (i >= s.length() - 1) {
            return s;
        }

        if ((s.charAt(i) == 'A' && s.charAt(i + 1) == 'B') || (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D')) {
            if (i > 0) {
                return removeSubstring(s.substring(0, i) + s.substring(i + 2), i - 1);
            } else {
                return removeSubstring(s.substring(0, i) + s.substring(i + 2), i);
            }
        }
        return s;
    }
}