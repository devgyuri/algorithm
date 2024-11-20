class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[] count = new int[3];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        if (count[0] < k || count[1] < k || count[2] < k) {
            return -1;
        }

        int maxWindow = 0;
        for (int start = 0, end = 0; end < n; end++) {
            count[s.charAt(end) - 'a']--;

            while (start < end && (count[0] < k || count[1] < k || count[2] < k)) {
                count[s.charAt(start) - 'a']++;
                start++;
            }

            if (count[0] >= k && count[1] >= k && count[2] >= k) {
                maxWindow = Math.max(maxWindow, end - start + 1);
            }
        }
        return n - maxWindow;
    }
}