class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxCount = 0;
        for (int r = 0; r < m; r++) {
            int count = 1;
            for (int i = r + 1; i < m; i++) {
                boolean isSamePattern = true;
                int target = matrix[r][0] ^ matrix[i][0];
                for (int c = 1; c < n; c++) {
                    if ((matrix[r][c] ^ matrix[i][c]) != target) {
                        isSamePattern = false;
                        break;
                    }
                }

                if (isSamePattern) {
                    count++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}