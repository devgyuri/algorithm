class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }

        int sum = 0;
        int startIndex = 0;
        if (k > 0) {
            startIndex = 0;
        } else {
            k = -k;
            startIndex = n - k - 1;
        }
        for (int i = 0; i < k; i++) {
            sum += code[(startIndex + i) % n];
        }
        for (int i = 0; i < n; i++) {
            sum -= code[(startIndex + i) % n];
            sum += code[(startIndex + i + k) % n];
            ans[i] = sum;
        }
        return ans;
    }
}