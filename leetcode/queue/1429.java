class FirstUnique {
    List<Integer> list;
    Map<Integer, Integer> freq;
    int firstIndex;

    public FirstUnique(int[] nums) {
        list = new ArrayList<>();
        freq = new HashMap<>();
        for (int num: nums) {
            list.add(num);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
    }
    
    public int showFirstUnique() {
        int n = list.size();
        for (int i = firstIndex; i < n; i++) {
            if (freq.get(list.get(i)) == 1) {
                firstIndex = i;
                return list.get(firstIndex);
            }
        }
        return -1;
    }
    
    public void add(int value) {
        list.add(value);
        freq.put(value, freq.getOrDefault(value, 0) + 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */