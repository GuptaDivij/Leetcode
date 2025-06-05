class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        long product = 1;
        for(int n : nums){
            if(target%n != 0){
                return false;
            }
            product *= n;
        }
        if(product == target*target){
            return true;
        }
        return false;
    }
}
