class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(coins.length==1 && amount%coins[0]!=0) return -1;
        else if(coins.length==1) return amount/coins[0];
        int [] allAmountMinimums = new int[amount+1];
        Arrays.fill(allAmountMinimums, amount + 1); 
        allAmountMinimums[0]=0;
        for(int i = 1; i<=amount; i++){
            for(int coin : coins){
                if(i-coin<0) continue;
                allAmountMinimums[i] = Math.min(allAmountMinimums[i], 1 + allAmountMinimums[i - coin]);
            }
        }
        return (allAmountMinimums[amount]==amount+1)?-1:allAmountMinimums[amount];
    }
}