class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num:nums) {
            numSet.add(num);
        }
        Arrays.sort(nums);
        
        int maxValue = nums[nums.length - 1];
        int longest = 0;
        for (int num: nums) {
            int curr = num;
            int len = 0;
            while (curr <= maxValue && numSet.contains(curr)) {
                numSet.remove(curr);
                curr *= curr;
                len++;
                longest = Math.max(longest, len);
            }
        }
        return longest == 1 ? -1 : longest;
    }
}