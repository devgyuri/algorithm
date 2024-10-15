class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        long count = 0L;
        while (left < right) {
            while (left < right && s.charAt(left) == '0') {
                left++;
            }
            while (left < right && s.charAt(right) == '1') {
                right--;
            }

            count += right - left;
            left++;
            right--;
        }
        return count;
    }
}