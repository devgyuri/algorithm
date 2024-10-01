class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainder = new HashMap<>();
        for (int num: arr) {
            remainder.put(num % k, remainder.getOrDefault(num % k, 0) + 1);
        }

        for (int key: remainder.keySet()) {
            if (key > 0 && remainder.containsKey(k - key)) {
                int pair = 
            }
        }
    }
}