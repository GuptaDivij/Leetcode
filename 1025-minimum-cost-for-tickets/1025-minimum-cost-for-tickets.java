class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int minCost[] = new int[lastDay + 1];
        int i = 0;
        for (int day = 1; day <= lastDay; day++) {
            if (day < days[i]) minCost[day] = minCost[day - 1];
            else {
                int oneDay = costs[0] + minCost[day-1];
                int sevenDay = costs[1] + minCost[Math.max(0,day-7)];
                int thirtyDay = costs[2] + minCost[Math.max(0,day-30)];
                minCost[day] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
                i++;
            }
        }
        return minCost[lastDay];
    }
}