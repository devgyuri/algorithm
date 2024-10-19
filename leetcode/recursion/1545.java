class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1 && k == 1) {
            return '0';
        }

        int pivot = (int) Math.pow(2, n - 1);
        if (k < pivot) {
            return findKthBit(n - 1, k);
        } else if (k == pivot) {
            return '1';
        } else {
            return findKthBit(n - 1, pivot * 2 - k) == '1' ? '0' : '1';
        }
    }
}