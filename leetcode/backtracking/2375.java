class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        int minValue = 0;
        int currValue = 1;
        int[] digits = new int[n + 1];

        digits[0] = 1;
        int index = 1;
        for (char c : pattern.toCharArray()) {
            if (c == 'D') {
                currValue--;
                minValue = Math.min(minValue, currValue);
            } else {
                currValue++;
            }
            digits[index++] = currValue;
        }

        StringBuilder ans = new StringBuilder();
        for (int digit : digits) {
            ans.append(digit - Math.min(0, minValue));
        }
        return ans.toString();
    }
}