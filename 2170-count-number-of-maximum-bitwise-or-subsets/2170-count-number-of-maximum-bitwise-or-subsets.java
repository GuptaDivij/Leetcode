class Solution {
    private int res;
    private int max;
    public int countMaxOrSubsets(int[] nums) {
        max = 0;
        for(int n:nums) max = max|n;
        res = 0;
        helper(nums, 0, 0);
        return res;
    }

    public void helper(int[]nums, int idx, int curr){
        if (idx == nums.length) {
            if (curr == max) res++;
            return;
        }
        helper(nums, idx + 1, curr | nums[idx]);
        helper(nums, idx + 1, curr);
    }
}