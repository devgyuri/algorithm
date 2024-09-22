class Solution {
    public int findKthNumber(int n, int k) {
        int num = 1;
        for (int i = 1; i < k; i++) {
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num % 10 == 9 || num >= n) {
                    num /= 10;
                }
                num += 1;
            }
        }
        return num;
    }
}