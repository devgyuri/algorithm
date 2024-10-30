class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] lisLength = new int[n];
        int[] ldsLength = new int[n];
        
        Arrays.fill(lisLength, 1);
        Arrays.fill(ldsLength, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    lisLength[i] = Math.max(lisLength[i], lisLength[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    ldsLength[i] = Math.max(ldsLength[i], ldsLength[j] + 1);
                }
            }
        }

        int minRemovals = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (lisLength[i] > 1 && ldsLength[i] > 1) {
                minRemovals = Math.min(minRemovals, n - lisLength[i] - ldsLength[i] + 1);
            }
        }
        return minRemovals;
    }
}