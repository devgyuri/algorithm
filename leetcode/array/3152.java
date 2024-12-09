class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] special = new int[n];
        int left = 0;
        int right = 0;
        while (left < n) {
            int parity = nums[left] % 2;
            while (right < n && parity != (nums[right] % 2)) {
                right++;
                parity = 1 - parity;
            }
            
            for (int i = left; i < right; i++) {
                special[i] = right - 1;
            }
            left = right;
            right = left + 1;
        }

        int m = queries.length;
        boolean[] answer = new boolean[m];
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            answer[i] = q[1] <= special[q[0]];
        }
        return answer;
    }
}