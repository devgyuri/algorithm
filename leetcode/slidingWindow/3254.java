class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 || k == 1) {
            return nums;
        }

        int[] power = new int[n - k + 1];
        int consecutiveCount = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1;
            }

            if (i >= k - 1) {
                if (consecutiveCount >= k) {
                    power[i - k + 1] = nums[i];
                } else {
                    power[i - k + 1] = -1;
                }    
            }
        }
        return power;
    }
}