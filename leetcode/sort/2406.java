class Solution {
    public int minGroups(int[][] intervals) {
        List<List<int[]>> groups = new ArrayList<>();
        for (int[] interval: intervals) {
            boolean addNew = true;
            for (List<int[]> group: groups) {
                if (isValidGroup(group, interval)) {
                    addNew = false;
                    break;
                }
            }
            if (addNew) {
                groups.add(new ArrayList<>());
                groups.get(groups.size() - 1).add(interval);
            }
        }
        return groups.size();
    }

    private boolean isValidGroup(List<int[]> group, int[] interval) {
        int left = 0, right = group.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (group.get(mid)[0] == interval[0]) {
                return false;
            } else if (group.get(mid)[0] > interval[0]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left > 0 && group.get(left-1)[1] >= interval[0]) {
            return false;
        }
        if (right < group.size() && group.get(left)[0] <= interval[1]) {
            return false;
        }
        group.add(left, interval);
        return true;
    }
}