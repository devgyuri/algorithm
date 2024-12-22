class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[][] memo = costs.clone();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int prevMin = Integer.MAX_VALUE;
                for (int x = 0; x < k; x++) {
                    if (x != j) {
                        prevMin = Math.min(prevMin, memo[i - 1][x]);
                    }
                }
                memo[i][j] += prevMin;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ans = Math.min(ans, memo[n - 1][i]);
        }
        return ans;
    }
}