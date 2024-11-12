class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        TreeMap<Integer, Integer> beautyMap = new TreeMap<>();
        for(int[] item : items) {
            beautyMap.put(item[0], Math.max(beautyMap.getOrDefault(item[0], 0), item[1]));
        }

        int maxBeauty = 0;
        for (int price : beautyMap.keySet()) {
            maxBeauty = Math.max(maxBeauty, beautyMap.get(price));
            beautyMap.put(price, maxBeauty);
        } 

        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int q = queries[i];
            if (beautyMap.floorKey(q) != null) {
                ans[i] = beautyMap.floorEntry(q).getValue();
            }
        }
        return ans;
    }
}