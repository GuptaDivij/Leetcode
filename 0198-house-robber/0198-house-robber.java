class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for(int i = 2; i<nums.length; i++){
            int temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    }
}