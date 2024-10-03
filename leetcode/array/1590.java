class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        prefix[0] = 0;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i] % p;
        }

        long sum = 0;
        for (int num: nums) {
            sum += num;
        }
        long target = sum % p;
        if (target == 0) {
            return 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j < n + 1; j++) {
                if ((prefix[j] - prefix[j - i]) % p == target) {
                    return i;
                }
            }
        }
        return -1;
    }
}