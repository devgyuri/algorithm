class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> multies = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int mul = nums[i] * nums[j];
                multies.put(mul, multies.getOrDefault(mul, 0) + 1);
            }
        }

        int ans = 0;
        for (int key: multies.keySet()) {
            if (multies.get(key) >= 2) {
                int pair = multies.get(key);
                ans += pair * (pair - 1) * 4;
            }
        }
        return ans;
    }
}