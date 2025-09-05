class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int res = 0;
        int ct = 1;
        int diff = nums[1]-nums[0];
        for(int i = 2; i<nums.length; i++){
            if(nums[i]-nums[i-1]==diff){
                res+=ct;
                ct++;
            }
            else{
                ct=1;
                diff=nums[i]-nums[i-1];
            }
        }
        return res;
    }
}