class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] ans = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (isWater[r][c] == 1) {
                    queue.offer(new int[] {r, c});
                }
            }
        }

        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] d : directions) {
                    int newRow = pos[0] + d[0];
                    int newCol = pos[1] + d[1];
                    if (isValid(newRow, newCol, ans, isWater)) {
                        ans[newRow][newCol] = height;
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
        }
        
        return ans;
    }

    private boolean isValid(int r, int c, int[][] mat, int[][] isWater) {
        return (r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == 0 && isWater[r][c] != 1);
    }
}