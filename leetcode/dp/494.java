class Solution {
    private int wayCount = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return wayCount;
    }

    private void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            wayCount += (sum == target) ? 1 : 0;
            return;
        }

        backtrack(nums, target, index + 1, sum + nums[index]);
        backtrack(nums, target, index + 1, sum - nums[index]);
    }
}