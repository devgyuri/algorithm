class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int n = nums.length;
        int currLen = nums[0] != nums[1] ? 2 : 1;
        int maxLen = currLen;
        int increasing = nums[0] < nums[1] ? 1 : 0;
        for (int i = 2; i < n; i++) {
            if (increasing == 0 && nums[i - 1] > nums[i]) {
                currLen++;
            } else if (increasing == 1 && nums[i - 1] < nums[i]) {
                currLen++;
            } else {
                maxLen = Math.max(maxLen, currLen);
                currLen = nums[i - 1] != nums[i] ? 2 : 1;
                increasing = nums[i - 1] < nums[i] ? 1 : 0;
            }
        }
        maxLen = Math.max(maxLen, currLen);
        return maxLen;
    }
}