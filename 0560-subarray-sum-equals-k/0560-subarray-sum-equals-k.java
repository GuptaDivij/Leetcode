class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumsFreq = new HashMap<>();
        int currSum = 0;
        int res = 0;
        for(int n : nums){
            currSum += n;
            if(currSum==k) res++;
            if(sumsFreq.containsKey(currSum-k)) res+=sumsFreq.get(currSum-k);
            sumsFreq.put(currSum, sumsFreq.getOrDefault(currSum,0)+1);
        }
        return res;
    }
}