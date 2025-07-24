class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // represents number of changes when word1 is length i and word2 is j
        int [][] dp = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                // insert all j characters word2 when word1 length is 0
                if(i==0) dp[i][j] = j;
                // delete all i characters of word1 when word2 length is 0
                else if(j==0) dp[i][j] = i;
                // if the characters are same, no change necessary
                else if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else {
                    // we can insert new character to word1 from i-1 length
                    int insert = dp[i-1][j]+1;
                    // we can delete a character ?
                    int delete = dp[i][j-1]+1;
                    // we can replace a character to match it to j
                    int replace = dp[i-1][j-1]+1;
                    dp[i][j]=Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        return dp[m][n];
    }
}