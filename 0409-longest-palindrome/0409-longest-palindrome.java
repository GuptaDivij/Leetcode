class Solution {
    public int longestPalindrome(String s) {
        int[] freqArr = new int[52]; 
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                freqArr[c - 'a']++;
            } else {
                freqArr[c - 'A' + 26]++;
            }
        }
        int res = 0;
        boolean hasOdd = false;
        for (int n : freqArr) {
            if (n % 2 == 0) {
                res += n;
            } else {
                res += n - 1; 
                hasOdd = true; 
            }
        }
        return hasOdd ? res + 1 : res;
    }
}
