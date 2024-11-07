class Solution {
    public int largestCombination(int[] candidates) {
        int maxCount = 0;
        for (int i = 0; i < 32; i++) {
            int target = 1 << i;
            int count = 0;
            for (int c : candidates) {
                if ((c & target) > 0) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}