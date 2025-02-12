class Solution {
    public int maximumSum(int[] nums) {
        int ans = -1;
        Map<Integer, Integer> digitSumMap = new HashMap<>();
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (digitSumMap.containsKey(digitSum)) {
                ans = Math.max(ans, digitSumMap.get(digitSum) + num);
            }
            digitSumMap.put(digitSum, Math.max(digitSumMap.getOrDefault(digitSum, 0), num));
        }
        return ans;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}