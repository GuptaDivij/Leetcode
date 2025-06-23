// Time Complexity : O(NS) where N is the length of the strs and S is the max length of the strings in strs
// Space Complexity : O(N) for the map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I made a frequency array to count the frequency of each character in the string.
// I used this array as a key, to avoid confusion with 2 or more digit numbers, I used # as a separator.
// I then used this key to group the anagrams together in a map.

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}