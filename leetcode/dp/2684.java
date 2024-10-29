class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] memo = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            memo[r][0] = true;
        }

        int moves = 0;
        for (int c = 1; c < n; c++) {
            for (int r = 0; r < m; r++) {
                if (grid[r][c] > grid[r][c - 1]) {
                    memo[r][c] = memo[r][c] | (true & memo[r][c - 1]);
                }
                if (r - 1 >= 0 && grid[r][c] > grid[r - 1][c - 1]) {
                    memo[r][c] = memo[r][c] | (true & memo[r - 1][c - 1]);
                }
                if (r + 1 < m && grid[r][c] > grid[r + 1][c - 1]) {
                    memo[r][c] = memo[r][c] | (true & memo[r + 1][c - 1]);
                }

                if (memo[r][c]) {
                    moves = Math.max(moves, c);
                }
            }
        }
        return moves;
    }
}