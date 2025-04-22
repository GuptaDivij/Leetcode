class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            freq[c - 'A']++;
            
            maxFreq = Math.max(maxFreq, freq[c - 'A']); // Track the max freq *in the current window*
            
            // Check if we need to shrink the window
            if ((end - start + 1) - maxFreq > k) {
                freq[s.charAt(start) - 'A']--;
                start++; // shrink from the left
            }
            
            // Track the longest valid window
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
