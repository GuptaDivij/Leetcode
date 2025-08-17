class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int [] minCost = new int[days[days.length-1]+1]; 
        for (int i = 0; i < days.length; i++) {
            int day = days[i];
            int oneDay = costs[0] + minCost[findClosestDay(days, 1, i)];
            int sevenDay = costs[1] + minCost[findClosestDay(days, 7, i)];
            int thirtyDay = costs[2] + minCost[findClosestDay(days, 30, i)];
            minCost[day] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
        }
        return minCost[days[days.length - 1]];
    }

    public int findClosestDay(int[] days, int period, int idx) {
        for (int i = idx - 1; i >= 0; i--) {
            if (period <= days[idx] - days[i]) {
                return days[i];
            }
        }
        return 0; 
    }
}
