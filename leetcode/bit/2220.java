class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int flipCount = 0;
        while (xor > 0) {
            flipCount += xor & 1;
            xor = xor >> 1;
        }
        return flipCount;
    }
}