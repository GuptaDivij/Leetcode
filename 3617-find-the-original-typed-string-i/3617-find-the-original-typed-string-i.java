class Solution {
    public int possibleStringCount(String word) {
        int res = 1;
        int i = 0;
        while(i<word.length()-1){
            int ct = 1;
            while(ct+i<word.length() && word.charAt(i)==word.charAt(ct+i)) ct++;
            i+=ct;
            res += ct-1;
        }
        return res;
    }
}

// 0 + 2 + 4 - 1 common = 5
// 1 + (1) + (3)
// 1 + (3)