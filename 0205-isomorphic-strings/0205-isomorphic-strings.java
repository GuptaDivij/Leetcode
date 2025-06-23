// Time Complexity : O(n) where n is the length of the string s and t
// Space Complexity : O(n) for the map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I used a HashMap to map characters in string s to characters in string t.
// I checked if the character in s is already mapped to a different character in t or if
// the character in t is already mapped to a different character in s. If any condition
// is satisfied, I return false. If the lengths of s and t are not equal, I return false.
// Edge case is if the length of s and t are not equal, I return false.

import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false; 
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){      
            if(!map.containsKey(s.charAt(i))){
                if(!map.containsValue(t.charAt(i))) map.put(s.charAt(i), t.charAt(i));
                else return false; 
            }
            else if(map.get(s.charAt(i))!=t.charAt(i)) return false;
        }
        return true;
    }
}