class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, target);
    }
    public int helper(int[] nums, int idx, int target){
        if(idx==nums.length){
            if(target==0) return 1;
            else return 0;
        }
        int add = helper(nums, idx+1, target-nums[idx]);
        int sub = helper(nums, idx+1, target+nums[idx]);
        return add+sub;
    }
}