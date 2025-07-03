class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int idx = 0;
        List<List<Integer>> res = new ArrayList<>();
        while(idx<nums.length-2){
            if(idx>0 && nums[idx]==nums[idx-1]){
                idx++;
                continue;
            }
            int low = idx+1;
            int high = nums.length-1;
            while(low<high){
                if(nums[low] + nums[high] + nums[idx] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[idx]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    res.add(list);
                    low++;
                    high--;
                    while(low<high && nums[low]==nums[low-1]) low++;
                    while(high>low && nums[high]==nums[high+1]) high--;
                }
                else if(nums[low] + nums[high] + nums[idx] < 0) low ++;
                else high--;
            }
            idx++;
        }
        return res;
    }
}

// 1,2,-1