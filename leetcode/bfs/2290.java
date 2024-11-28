class Solution {

    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {0, 0, 0});

        while (!pq.isEmpty()) {
            int[] currentCell = pq.poll();
            int x = currentCell[0];
            int y = currentCell[1];
            int o = currentCell[2];

            for (int[] d : DIRECTIONS) {
                int newX = x + d[0];
                int newY = y + d[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newY][newX]) {
                    int newO = grid[newY][newX] == 0 ? o : o + 1;
                    if (newX == n - 1 && newY == m - 1) {
                        return newO;
                    }
                    pq.offer(new int[] {newX, newY, newO});
                    visited[newY][newX] = true;
                }
            }
        }
        return -1;
    }
}