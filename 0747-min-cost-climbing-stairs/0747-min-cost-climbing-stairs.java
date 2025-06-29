class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev2 = 0;  // dp[i - 2]
        int prev1 = 0;  // dp[i - 1]
        for (int i = 2; i <= cost.length; i++) {
            int oneStep = prev1 + cost[i - 1];
            int twoSteps = prev2 + cost[i - 2];
            int current = Math.min(oneStep, twoSteps);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
