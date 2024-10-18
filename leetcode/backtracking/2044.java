class Solution {

    private int count;

    public int countMaxOrSubsets(int[] nums) {
        this.count = 0;
        int target = 0;
        for (int num: nums) {
            target |= num;
        }

        dfs(nums, 0, 0, target);
        return this.count;
    }

    private void dfs(int[] nums, int index, int curr, int target) {
        if (index == nums.length) {
            if (curr == target) {
                this.count++;
            }
            return;
        }

        dfs(nums, index + 1, curr, target);
        dfs(nums, index + 1, curr | nums[index], target);
    }
}