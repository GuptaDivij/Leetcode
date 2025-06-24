class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int[]arr = new int[nums.length];
        ArrayList<Integer> keyIndices = new ArrayList<>();
        for(int i=0; i<nums.length;i++) if(nums[i] == key) keyIndices.add(i);
        for(int n: keyIndices){
            for(int i=n-k; i<=n+k; i++){
                if(i>=0 && i<nums.length) arr[i] = 1;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<nums.length;i++) if(arr[i]==1) ans.add(i);
        return ans;
    }
}

// Find all the indices for nums[i]==key
// go +-k for these indices