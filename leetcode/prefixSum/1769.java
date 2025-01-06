class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        Set<Integer> position = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                position.add(i);
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int p : position) {
                ans[i] += Math.abs(i - p);
            }
        }
        return ans;
    }
}