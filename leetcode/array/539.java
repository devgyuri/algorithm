class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> timeNums = new ArrayList<>();
        for (String t: timePoints) {
            timeNums.add(Integer.parseInt(t.substring(0, 2)) * 60 + Integer.parseInt(t.substring(3)));
        }
        Collections.sort(timeNums);

        int n = timeNums.size();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, timeNums.get(i) - timeNums.get(i - 1));
        }
        minDiff = Math.min(minDiff, Math.min(timeNums.get(n - 1) - timeNums.get(0), 24 * 60 - (timeNums.get(n - 1) - timeNums.get(0))));
        return minDiff;
    }
}