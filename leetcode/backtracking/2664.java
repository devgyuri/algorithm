class Solution {

    private static final int[][] DIRECTIONS = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public int[][] tourOfKnight(int m, int n, int r, int c) {
        int[][] order = new int[m][n];
        for (int i = 0; i < DIRECTIONS.length; i++) {
            if (fillOrder(order, m, n, r, c, i)) {
                return order;
            }
        }

        return order;
    }

    private boolean fillOrder(int[][] order, int m, int n, int r, int c, int start) {
        for (int[] o: order) {
            Arrays.fill(o, -1);
        }

        int count = 0;
        int row = r, col = c;
        while (count < m * n) {
            if (order[row][col] != -1) {
                return false;
            }
            order[row][col] = count++;

            for (int i = 0; i < DIRECTIONS.length; i++) {
                int[] d = DIRECTIONS[(i + start) % DIRECTIONS.length];
                int nextRow = row + d[0];
                int nextCol = col + d[1];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && order[nextRow][nextCol] == -1) {
                    row = nextRow;
                    col = nextCol;
                    break;
                }
            }
        }
        return true;
    }
}