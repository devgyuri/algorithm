class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            pq.offer(gift);
        }

        for (int i = 0; i < k; i++) {
            int pile = pq.poll();
            pile = (int) Math.sqrt(pile);
            pq.offer(pile);
        }

        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}