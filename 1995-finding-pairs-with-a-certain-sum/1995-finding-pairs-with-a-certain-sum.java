class FindSumPairs {
    private HashMap<Integer, Integer> freqMap2;
    private HashMap<Integer, Integer> numsOne;
    private int [] nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums2 = nums2;
        freqMap2 = new HashMap<>();
        numsOne = new HashMap<>();
        for (int num : nums1) {
            numsOne.put(num, numsOne.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            freqMap2.put(num, freqMap2.getOrDefault(num, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int oldVal = nums2[index];
        int newVal = oldVal + val;
        nums2[index] = newVal;
        freqMap2.put(oldVal, freqMap2.get(oldVal) - 1);
        if (freqMap2.get(oldVal) == 0) freqMap2.remove(oldVal);
        freqMap2.put(newVal, freqMap2.getOrDefault(newVal, 0) + 1);
    }
    
    public int count(int tot) {
        int count = 0;
        for (int num1 : numsOne.keySet()) {
            int complement = tot - num1;
            int freq1 = numsOne.get(num1);
            int freq2 = freqMap2.getOrDefault(complement, 0);
            count += freq1 * freq2;
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */