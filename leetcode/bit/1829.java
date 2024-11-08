class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] ans = new int[n];
        int mask = (1 << (maximumBit)) - 1;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
            ans[n - i - 1] = (~ xor) & mask;
        }
        return ans;
    }
}