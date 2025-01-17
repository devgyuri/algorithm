class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int curr = 0;
        for (int i = 0; i < n - 1; i++) {
            curr ^= derived[i];
        }
        return derived[n - 1] == (0 ^ curr);
    }
}