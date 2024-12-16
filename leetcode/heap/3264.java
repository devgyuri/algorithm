class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {nums[i], i});
        }

        for (int i = 0; i < k; i++) {
            int[] curr = pq.poll();
            curr[0] *= multiplier;
            pq.offer(curr);
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int num = curr[0];
            int index = curr[1];
            nums[index] = num;
        }
        return nums;
    }
}