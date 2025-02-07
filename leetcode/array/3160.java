class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballMap = new HashMap<>();
        Map<Integer, Integer> colorMap = new HashMap<>();
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if (ballMap.containsKey(ball)) {
                int prevColor = ballMap.get(ball);
                colorMap.put(prevColor, colorMap.get(prevColor) - 1);
                if (colorMap.get(prevColor) == 0) {
                    colorMap.remove(prevColor);
                }
            }

            ballMap.put(ball, color);
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            ans[i] = colorMap.size();
        }
        return ans;
    }
}