class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int lowerBound = n - 1;
        int upperBound = n - 1;
        long count = 0;
        for (int i = 0; i < n; i++) {
            int currNum = nums[i];
            while (upperBound > i && nums[upperBound] > upper - currNum) {
                upperBound--;
            }
            while (lowerBound > i && nums[lowerBound] >= lower - currNum) {
                lowerBound--;
            }
            if ((lowerBound == i || currNum + nums[lowerBound] < lower) && currNum + nums[upperBound] <= upper) {
                count += upperBound - lowerBound;
            } else {
                break;
            }
        }
        return count;
    }
}