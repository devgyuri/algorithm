class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int[] pointers = new int[k];
        int[] range = new int[] {(int) -1e5, (int) 1e5};
        while (pointers[0] < nums.get(0).size()) {
            int left = 0;
            int right = 0;
            int target = nums.get(0).get(pointers[0]);
            for (int i = 1; i < k; i++) {
                if (pointers[i] == nums.get(i).size() - 1) {
                    continue;
                }

                int currDiff = nums.get(i).get(pointers[i]) - target;
                int nextDiff = nums.get(i).get(pointers[i] + 1) - target;
                while (pointers[i] + 1 < nums.get(i).size() && (Math.abs(nextDiff) < Math.abs(currDiff) || currDiff == nextDiff)) {
                    pointers[i]++;
                    currDiff = nextDiff;
                    if (pointers[i] + 1 < nums.get(i).size()) {
                        nextDiff = nums.get(i).get(pointers[i] + 1) - target;
                    }
                }
                left = Math.min(left, nums.get(i).get(pointers[i]) - target);
                right = Math.max(right, nums.get(i).get(pointers[i]) - target);
            }
            
            if (right - left < range[1] - range[0]) {
                range[0] = target + left;
                range[1] = target + right;
            }
            pointers[0]++;
        }
        return range;
    }
}