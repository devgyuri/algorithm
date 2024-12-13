class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] isDeleted = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {nums[i], i});
        }

        long score = 0;
        while (!pq.isEmpty()) {
            int[] minPair = pq.poll();
            if (isDeleted[minPair[1]]) {
                continue;
            } else {
                score += minPair[0];
                isDeleted[Math.max(minPair[1] - 1, 0)] = true;
                isDeleted[Math.min(minPair[1] + 1, n - 1)] = true;
            }
        }
        return score;
    }
}