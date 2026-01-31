class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int prof1 = 0;
        int finalProf = 0;
        // Basically use old profit to buy new stock
        for(int i = 0; i<prices.length; i++){
            // buy1 to be lowest
            buy1 = Math.min(prices[i], buy1);
            // same as buy & sell stock -> Max - min = profit
            prof1 = Math.max(prof1, prices[i] - buy1); 
            // now use this profit to buy the next stock
            buy2 = Math.min(buy2, prices[i] - prof1);
            // final profit is from selling this stock also using old profit
            finalProf = Math.max(finalProf, prices[i] - buy2);
        }
        return finalProf;
    }
}