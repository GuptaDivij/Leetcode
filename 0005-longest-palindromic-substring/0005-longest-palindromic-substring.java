class Solution {
    public String longestPalindrome(String s) {
        int start = 0; 
        int end = 0;
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        for(int i = 0; i<n; i++) dp[i][i] = true;
        for(int i = 1; i<n; i++){
            // other points
            for (int j = 0; j<n-i; j++){
                if(s.charAt(j)==s.charAt(j+i) && (i==1 || dp[j+1][j+i-1])){
                    dp[j][j+i] = true;
                    if(i>end-start){
                        end = j+i;
                        start = j;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}