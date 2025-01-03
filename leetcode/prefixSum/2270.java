class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int n = nums.length;
        int ans = 0;
        long currSum = 0;
        for (int i = 0; i < n - 1; i++) {
            currSum += nums[i];
            if (currSum >= totalSum - currSum) {
                ans++;
            }
        }
        return ans;
    }
}