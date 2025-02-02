class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int[] checkedSorted = new int[n];
        for (int rotationOffset = 0; rotationOffset < n; rotationOffset++) {
            int currIndex = 0;
            for (int index = rotationOffset; index < n; index++) {
                checkedSorted[currIndex++] = nums[index];
            }
            for (int index = 0; index < rotationOffset; index++) {
                checkedSorted[currIndex++] = nums[index];
            }

            boolean isSorted = true;
            for (int index = 0; index < n - 1; index++) {
                if (checkedSorted[index]> checkedSorted[index + 1]) {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted) {
                return true;
            }
        }
        return false;
    }
}