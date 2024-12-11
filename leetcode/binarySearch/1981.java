class Solution {
    public int maxLength(int[] ribbons, int k) {
        int left = 1;
        int right = 0;
        for (int r : ribbons) {
            right = Math.max(right, r);
        }

        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getCount(ribbons, mid) >= k) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private int getCount(int[] ribbons, int size) {
        int count = 0;
        for (int r : ribbons) {
            count += r / size;
        }
        return count;
    }
}