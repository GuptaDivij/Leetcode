class Solution {
    public int firstMissingPositive(int[] nums) {
        // missing will be from 1 to n
        // keep swapping till not in place
        int n = nums.length;
        
        // Place each number at its correct position (nums[i] should be at index nums[i]-1)
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        
        // Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If all positions are filled correctly, return n + 1
        return n + 1;
    }
}