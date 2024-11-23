class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];
        for (char[] row : ans) {
            Arrays.fill(row, '.');
        }

        for (int r = 0; r < m; r++) {
            int count = 0;
            for (int c = 0; c < n; c++) {
                if (box[r][c] == '#') {
                    count++;
                } else if (box[r][c] == '*') {
                    while (count > 0) {
                        ans[c - count][m - r - 1] = '#';
                        count--;
                    }
                    ans[c][m - r - 1] = '*';
                }
            }
            while (count > 0) {
                ans[n - count][m - r - 1] = '#';
                count--;
            }
        }
        return ans;
    }
}