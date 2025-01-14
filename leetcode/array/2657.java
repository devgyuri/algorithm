class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        long seenA = 0;
        long seenB = 0;
        for (int i = 0; i < n; i++) {
            seenA |= (1L << A[i]);
            seenB |= (1L << B[i]);
            ans[i] = Long.bitCount(seenA & seenB);
        }
        return ans;
    }
}