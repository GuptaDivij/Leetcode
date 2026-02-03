class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i<nums.length; i++){
            int pick = nums[i]+nums[i-2];
            int notPick = nums[i-1];
            nums[i] = Math.max(pick, notPick);
        }
        return nums[nums.length-1];
    }
}