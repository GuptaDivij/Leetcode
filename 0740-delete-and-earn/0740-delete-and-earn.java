import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            max = Math.max(max, n);
        }

        int [] dp = new int[max+1];
        for(int i = 1; i<dp.length; i++){
            int include = (map.containsKey(i)?map.get(i):0)*i + ((i-2)>=0?dp[i-2]:0);
            int exclude = dp[i-1];
            dp[i] = Math.max(include, exclude);
        }
        return dp[max];
    }

}