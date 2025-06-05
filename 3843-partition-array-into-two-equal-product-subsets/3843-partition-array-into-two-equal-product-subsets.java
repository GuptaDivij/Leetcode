class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        long product = 1;
        for(int n : nums){
            product *= n;
        }

        if(product != target*target){
            return false;
        }
        return canFormTarget(nums, 0, 1, target);
    }
    private boolean canFormTarget(int[]nums, int idx, long prod, long target){
        if(prod == target){
            return true;
        }
        if(idx == nums.length){
            return false;
        }
        return canFormTarget(nums, idx+1, prod*nums[idx], target) || canFormTarget(nums, idx+1, prod, target);
    }
}