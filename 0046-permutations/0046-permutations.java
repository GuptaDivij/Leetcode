class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        helper(nums, new ArrayList<>(), used);
        return res;
    }
    
    private void helper(int[] nums, List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            helper(nums, current, used);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
