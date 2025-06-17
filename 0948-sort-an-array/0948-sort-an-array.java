class Solution {
    public int[] sortArray(int[] nums) {
        HashMap<Integer,Integer> counts = new HashMap<>();
        int minVal = nums[0], maxVal = nums[0];
        for (int i = 0; i < nums.length; i++) {
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }
        int index = 0;
        for (int val = minVal; val <= maxVal; ++val) {
            while (counts.getOrDefault(val, 0) > 0) {
                nums[index] = val;
                index += 1;
                counts.put(val, counts.get(val) - 1);
            }
        }
        return nums;
    }
}