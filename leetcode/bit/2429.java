class Solution {
    public int minimizeXor(int num1, int num2) {
        if (Integer.bitCount(num1) > Integer.bitCount(num2)) {
            int x = 0;
            int setCount = Integer.bitCount(num2);
            int bitPos = 31;
            while (setCount > 0) {
                if ((num1 & (1 << bitPos)) > 0) {
                    x |= (1 << bitPos);
                    setCount--;
                } 
                bitPos--;
            }
            return x;
        } else {
            int x = num1;
            int setCount = Integer.bitCount(num2) - Integer.bitCount(num1);
            int bitPos = 0;
            while (setCount > 0) {
                if ((num1 & (1 << bitPos)) == 0) {
                    x |= (1 << bitPos);
                    setCount--;
                } 
                bitPos++;
            }
            return x;
        }
    }
}