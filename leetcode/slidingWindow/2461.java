class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> frequency = new HashMap<>();
        long maxSum = 0;
        long sum = 0;
        for (int i = 0; i < k; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }
        if (frequency.size() == k) {
            maxSum = Math.max(maxSum, sum);
        }

        for (int i = 0; i < n - k; i++) {
            frequency.put(nums[i + k], frequency.getOrDefault(nums[i + k], 0) + 1);
            sum += nums[i + k];
            frequency.put(nums[i], frequency.get(nums[i]) - 1);
            sum -= nums[i];
            if (frequency.get(nums[i]) == 0) {
                frequency.remove(nums[i]);
            }

            if (frequency.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}