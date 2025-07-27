class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==1) return s;
        int[]range = new int[2];
        boolean [][]dp = new boolean[n][n];
        for(int i = 0; i<n; i++) dp[i][i] = true;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<n-i; j++){
                if (s.charAt(j) == s.charAt(j + i) && (i == 1 || dp[j + 1][j + i - 1])){
                    dp[j][j+i] = true;
                    if(i>(range[1]-range[0])) {
                        range[0]=j;
                        range[1]=j+i; 
                    }
                }
            }
        }
        return s.substring(range[0],range[1]+1);
    }
}