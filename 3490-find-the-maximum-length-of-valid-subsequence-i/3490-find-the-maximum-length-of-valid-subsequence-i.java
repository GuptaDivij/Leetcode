class Solution {
    public int maximumLength(int[] nums) {
        int o = 0;
        int e = 0; 
        int res = 1; 
        int parity = nums[0] % 2;
        for (int i = 0; i < nums.length; i++) {
            if (parity % 2 != nums[i] % 2) {
                res++;
                parity ^= 1;
            }
            if (nums[i] % 2 == 1) o++;
            else e++;
        }
        return Math.max(o, Math.max(e, res));
    }
}