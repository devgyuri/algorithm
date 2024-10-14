class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num: nums) {
            pq.offer(num);
        }
        
        long score = 0L;
        for (int i = 0; i < k; i++) {
            int curr = pq.poll();
            score += (long) curr;
            pq.offer(curr % 3 == 0 ? curr / 3 : curr / 3 + 1);
        }
        return score;
    }
}