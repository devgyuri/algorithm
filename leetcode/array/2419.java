class Solution {
    public int longestSubarray(int[] nums) {
        int maxValue = 0;;
        for (int num: nums) {
            maxValue = Math.max(maxValue, num);
        }

        int maxLength = 0;
        int currLength = 0;
        for (int num: nums) {
            if (num == maxValue) {
                currLength++;
                maxLength = Math.max(maxLength, currLength);
            } else {
                currLength = 0;
            }
        }
        return maxLength;
    }
}