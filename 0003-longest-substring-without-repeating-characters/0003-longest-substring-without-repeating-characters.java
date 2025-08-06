class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c) && map.get(c) >= start) start = map.get(c) + 1;
            int currLen = end - start + 1; 
            maxLen = Math.max(maxLen, currLen);
            map.put(c, end);
        }
        return maxLen;
    }
}
