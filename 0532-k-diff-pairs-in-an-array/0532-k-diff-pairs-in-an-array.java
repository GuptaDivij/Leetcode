class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int n : nums){
            if(map.containsKey(n)) map.put(n, true); // it was seen before, and has a duplicate, multiple values
            else map.put(n, false); // we are seeing it for the first time
        }
        HashSet<Integer> seen = new HashSet<>();
        int count = 0;

        // O(nlogn) to O(n) 
        // 1, 1, 1, 1, 1
        for(int i = 0; i<nums.length;i++){
            if (seen.contains(nums[i])) continue;
            seen.add(nums[i]);
            if (k == 0) {
                if (map.get(nums[i])) count++; // count if duplicate exists
            } else {
                int targetPlus = nums[i] + k;
                if (map.containsKey(targetPlus)) count++;
            }
        }
        return count;
    }

}

// 1, 1, 3, 4, 5