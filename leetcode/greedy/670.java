class Solution {
    public int maximumSwap(int num) {
        int n = Integer.toString(num).length();
        Integer[] digits = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        
        Integer[] maxDigits = digits.clone();
        Arrays.sort(maxDigits, Collections.reverseOrder());

        int target = -1;
        int targetIndex = -1;
        for (int i = 0; i < n; i++) {
            if (digits[i] != maxDigits[i]) {
                target = maxDigits[i];
                targetIndex = i;
                break;
            }
        }

        if (targetIndex != -1) {
            for (int i = n - 1; i >= 0; i--) {
                if (digits[i] == target) {
                    int temp = digits[i];
                    digits[i] = digits[targetIndex];
                    digits[targetIndex] = temp;
                    break;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans *= 10;
            ans += digits[i];
        }
        return ans;
    }
}