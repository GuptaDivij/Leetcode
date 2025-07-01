class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ctZero = 0;
        int prod = 1;
        int [] res = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0){
                ctZero++;
                if(ctZero==2) return res;
                continue;
            }
            prod*=nums[i];
        }
        for(int i = 0; i<nums.length; i++){
            if(ctZero==1){
                if(nums[i]==0) res[i] = prod;
                else res[i]=0;
            }
            else res[i] = prod/nums[i];
        }
        return res;
    }
}