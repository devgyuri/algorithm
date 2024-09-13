class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int m = arr.length;
        int n = queries.length;
        int[] prefix = new int[m + 1];
        prefix[0] = arr[0];
        for (int i = 1; i <= m; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            ans[i] = prefix[right + 1] ^ prefix[left];
        }
        return ans;
    }
}