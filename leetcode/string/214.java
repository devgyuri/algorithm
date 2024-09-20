class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }

        int n = s.length();
        for (int i = n - 1; i > 0; i--) {
            if (s.charAt(i) == s.charAt(0) && isPalindrome(s, 0, i)) {
                StringBuilder ans = new StringBuilder(s.substring(i + 1));
                ans.reverse().append(s);
                return ans.toString();
            }
        }
        StringBuilder ans = new StringBuilder(s.substring(1));
        ans.reverse().append(s);
        return ans.toString();
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}