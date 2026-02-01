class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k];
        int[] profit = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        for(int price : prices){
            for(int j = 0; j<k; j++){
                if(j==0) buy[j] = Math.min(buy[j], price);
                else buy[j] = Math.min(buy[j], price - profit[j-1]);
                profit[j] = Math.max(profit[j], price - buy[j]);
            }
        }
        return profit[k-1];
    }
}