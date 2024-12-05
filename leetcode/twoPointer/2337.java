class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int leftBound = 0;
        int rightStart = n - 1;
        for (int tIndex = 0; tIndex < n; tIndex++) {
            if (target.charAt(tIndex) == 'L') {
                int sIndex = Math.max(tIndex, leftStart);
                while (sIndex < n) {
                    if (start.charAt(sIndex) == 'L') {
                        leftStart = sIndex + 1;
                    } else if (start.charAt(sIndex) == 'R') {
                        return false;
                    }
                    sIndex++;
                }
            } else if (target.charAt(tIndex) == 'R') {
                int sIndex = Math.min(tIndex, rightStart);
                while (sIndex >= 0) {
                    if (start.charAt(sIndex) == 'R') {
                        rightStart = sIndex - 1;
                    } else if (start.charAt(sIndex) == 'L') {
                        return false;
                    }
                    sIndex--;
                }
            }
        }
        return true;
    }
}