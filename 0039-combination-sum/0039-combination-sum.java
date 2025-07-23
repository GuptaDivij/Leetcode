class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    public void helper(int[] arr, int target, List<Integer> list, int idx){
        if(target==0) res.add(new ArrayList<>(list));
        if(target<=0) return;
        for(int i = idx; i<arr.length;i++){
            list.add(arr[i]);
            helper(arr, target-arr[i], list, idx++);
            list.remove(list.size()-1);
        }
    }
}