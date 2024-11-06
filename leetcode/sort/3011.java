class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        int[] setBits = new int[n];
        for (int i = 0; i < n; i++) {
            setBits[i] = countSetBist(nums[i]);
        }
    }

    private int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num = num >> 1;
        }
        return count;
    }
}