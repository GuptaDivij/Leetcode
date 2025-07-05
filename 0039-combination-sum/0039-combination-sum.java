class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        helper(candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }

    public void helper(int[] nums, int target, List<Integer> ans, int idx){
        if(target==0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        if(target<0) return;
        for(int i = idx; i<nums.length; i++){
            ans.add(nums[i]);
            helper(nums, target-nums[i], ans, i);
            ans.remove(ans.size()-1);
        }

    }
}