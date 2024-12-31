class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDate = 0;
        for (int day : days) {
            maxDate = Math.max(maxDate, day);
        }

        int[] memo = new int[maxDate + 1];
        memo[0] = 0;
        int currDate = 1;
        for (int day : days) {
            while (currDate < day) {
                memo[currDate] = memo[currDate - 1];
                currDate++;
            }

            memo[day] = Math.min(memo[day - 1] + costs[0], Math.min(day - 7 >= 0 ? memo[day - 7] + costs[1] : Integer.MAX_VALUE, day - 30 >= 0 ? memo[day - 30] + costs[2] : Integer.MAX_VALUE));
            currDate++;
        }
        return memo[maxDate];
    }
}