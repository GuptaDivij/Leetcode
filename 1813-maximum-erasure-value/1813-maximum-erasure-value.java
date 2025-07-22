class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int left = 0, right = 0;
        int maxSum = 0, windowSum = 0;

        while (right < nums.length) {
            if (!seen.contains(nums[right])) {
                seen.add(nums[right]);
                windowSum += nums[right];
                maxSum = Math.max(maxSum, windowSum);
                right++;
            } else {
                seen.remove(nums[left]);
                windowSum -= nums[left];
                left++;
            }
        }
        return maxSum;
    }
}
