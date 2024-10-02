class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return new int[] {};
        }

        int[][] indices = new int[n][2];
        for (int i = 0; i < n; i++) {
            indices[i] = new int[] {arr[i], i};
        }

        Arrays.sort(indices, (a, b) -> a[0] - b[0]);

        int[] rank = new int[n];
        int currRank = 1;
        rank[indices[0][1]] = 1;
        for (int i = 1; i < n; i++) {
            int prevIndex = indices[i - 1][1];
            int currIndex = indices[i][1];
            if (arr[prevIndex] != arr[currIndex]) {
                currRank++;
            }
            rank[currIndex] = currRank;
        }
        return rank;
    }
}