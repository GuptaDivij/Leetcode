// O(n!)

class Solution {
    public int countSubstrings(String s) {
        char[]str = s.toCharArray();
        int ct = s.length();
        for(int i = 1; i<s.length(); i++){
            for(int j = i; j<s.length(); j++){
                if(isPalindrome(str, j-i, j)) ct++;
            }
        }
        return ct;
    }
    private boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left++] != arr[right--]) return false;
        }
        return true;
    }

}