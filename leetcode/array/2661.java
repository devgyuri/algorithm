class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int k = arr.length;
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0 ; i < k; i++) {
            indexMap.put(arr[i], i);
        }

        int[][] indexMat = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                indexMat[r][c] = indexMap.get(mat[r][c]);
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (int r = 0; r < m; r++) {
            int currMax = 0;
            for (int c = 0; c < n; c++) {
                currMax = Math.max(currMax, indexMat[r][c]);
            }
            minIndex = Math.min(minIndex, currMax);
        }

        for (int c = 0; c < n; c++) {
            int currMax = 0;
            for (int r = 0; r < m; r++) {
                currMax = Math.max(currMax, indexMat[r][c]);
            }
            minIndex = Math.min(minIndex, currMax);
        }
        return minIndex;
    }
}