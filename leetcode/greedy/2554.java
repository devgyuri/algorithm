class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for (int b : banned) {
           bannedSet.add(b); 
        }
        
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (sum + i > maxSum) {
                break;
            }

            if (!bannedSet.contains(i)) {
                sum += i;
                count++;
            }
        }
        return count;
    }
}