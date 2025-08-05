class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) map.put(n, map.getOrDefault(n, 0)+1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums2){
            if(map.containsKey(n) && map.get(n) > 0){
                list.add(n);
                map.put(n, map.get(n)-1);
            }
        }
        int [] ans = new int [list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }       
}