class Solution {
    List<List<Integer>> finalList;
    public List<List<Integer>> subsets(int[] nums) {
        finalList = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>());
        return finalList;
    }
    public void helper (int[] nums, int idx, List<Integer> result){
        finalList.add(new ArrayList<>(result));
        for(int i = idx; i<nums.length; i++){
            result.add(nums[i]);
            helper(nums, i+1, result);
            result.remove(result.size()-1);
        }
    }
}