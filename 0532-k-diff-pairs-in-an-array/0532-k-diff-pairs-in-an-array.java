class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int n : nums){
            if(map.containsKey(n)) map.put(n, true); // it was seen before, and has a duplicate, multiple values
            else map.put(n, false); // we are seeing it for the first time
        }
        Arrays.sort(nums);
        int count = 0;

        // 1, 1, 1, 1, 1
        for(int i = 0; i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]) continue; // duplicate values
            if(k==0){
                if(map.get(nums[i])) count++;
                continue;
            }
            int targetPlus = k+nums[i];
            if(map.containsKey(targetPlus)) count++;
        }
        return count;
    }

}

// 1, 1, 3, 4, 5