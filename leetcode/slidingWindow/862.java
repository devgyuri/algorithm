class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int start = 0, end = 0; end < n; end++) {
            sum += nums[end];

            while (sum >= k) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}