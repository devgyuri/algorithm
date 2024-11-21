class Solution {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 1;
        }
        for (int[] w : walls) {
            grid[w[0]][w[1]] = 1;
        }

        int count = m * n - guards.length - walls.length;
        for (int[] g : guards) {
            int row = g[0];
            int col = g[1];
            for (int[] d : DIRECTIONS) {
                int newRow = row + d[0];
                int newCol = col + d[1];
                while (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] != 1) {
                    if (grid[newRow][newCol] == 0) {
                        count--;
                        grid[newRow][newCol] = 2;
                    }
                    newRow += d[0];
                    newCol += d[1];
                }
            }
        }
        return count;
    }
}