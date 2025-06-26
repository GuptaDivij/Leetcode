class Solution {

    public int longestSubsequence(String s, int k) {
        int currNumber = 0;
        int length = 0;
        int lengthOfK = (int) (Math.log(k) / Math.log(2)) + 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(s.length() - 1 - i);
            if (ch == '1') {
                if (i < lengthOfK && currNumber + (1 << i) <= k) {
                    currNumber += 1 << i;
                    length++;
                }
            }
            else length++;
        }
        return length;
    }
}