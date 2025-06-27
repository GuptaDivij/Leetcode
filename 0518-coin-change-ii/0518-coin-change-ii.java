class Solution {
    public int change(int amount, int[] coins) {
        int [] totalWaysToMakeAmount = new int[amount+1];
        totalWaysToMakeAmount[0]=1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                totalWaysToMakeAmount[i] += totalWaysToMakeAmount[i - coin];
            }
        }
        return totalWaysToMakeAmount[amount];
    }
}