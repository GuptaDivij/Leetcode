class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int [] allAmountMinimums = new int[amount+1];
        Arrays.fill(allAmountMinimums, amount + 1); 
        allAmountMinimums[0]=0;
        for(int i = 1; i<=amount; i++){
            for(int coin : coins){
                if(i-coin<0) break;
                allAmountMinimums[i] = Math.min(allAmountMinimums[i], 1 + allAmountMinimums[i - coin]);
            }
        }
        return (allAmountMinimums[amount]==amount+1)?-1:allAmountMinimums[amount];
    }
}