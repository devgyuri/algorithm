class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        PriorityQueue<Integer> returnChairs = new PriorityQueue<>((a, b) -> b - a); 

        int[] friends = new int[n];
        for (int i = 0; i < n; i++) {
            friends[i] = i;
        }
        Arrays.sort(friends, (a, b) -> times[a][0] - times[b][0]);

        for (int i = 0; i < n; i++) {
            int[] time = times[i];
            if (returnChairs.isEmpty())
        }
    }
}