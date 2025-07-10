class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums) totalSum+=num;
        if(totalSum%2!=0) return false;
        boolean [] dp = new boolean[totalSum/2+1];
        dp[0] = true;
        for(int num:nums) {
            for(int currSum = totalSum/2; currSum>=num; currSum--){
                dp[currSum] = dp[currSum] || dp[currSum-num];
                if(dp[totalSum/2])return true;
            }
        }
        return dp[totalSum/2];
    }
}