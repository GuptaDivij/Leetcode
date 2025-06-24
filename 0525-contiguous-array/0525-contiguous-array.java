class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int res = 0;
        map.put(0,-1); // till before the array starts, it is balanced
        for(int i = 0; i<nums.length;i++){
            if(nums[i]==0)count--;
            else count++;
            if(count==0) res=i+1;
            // if we seen this count before, equal number of ones and zeroes came up after that to balance it up
            // else, we just put the count on the map, we keep the first seen one to maximize the length
            else if(map.containsKey(count)) res = Math.max(res, i-map.get(count)); 
            else map.put(count, i);
        }
        return res;
    }
}
