class Solution {
    public int minimumLength(String s) {
        int[] count = new int [26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int ans = 0;
        for (int num : count) {
            if (num == 0) {
                continue;
            } else if (num % 2 == 0) {
                ans += 2;
            } else {
                ans += 1;
            }
        }
        return ans;
    }
}