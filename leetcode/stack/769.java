class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int chunk = 0;
        int curr = 0;
        while (curr < n) {
            int next = curr + 1;
            while (curr < next) {
                int temp = arr[curr];
                arr[curr] = arr[arr[curr]];
                arr[temp] = temp;

                next = Math.max(next, temp + 1);
                curr = arr[curr] == curr ? curr + 1 : curr;
            }
            chunk++;
            curr = next;
        }
        return chunk;
    }
}