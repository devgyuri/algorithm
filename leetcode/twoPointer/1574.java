class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int minLength = n;
        int end = n - 1;
        int start = 1;
        while (start <= end && arr[start - 1] <= arr[start]) {
            start++;
        }
        minLength = Math.min(minLength, end - start);
    }
}