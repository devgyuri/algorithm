class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                currSum += nums[i];
            } else {
                maxSum = Math.max(maxSum, currSum);
                currSum = nums[i];
            }
        }
        maxSum = Math.max(maxSum, currSum);
        return maxSum;
    }
}