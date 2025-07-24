class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j] represents the minimum number of operations required 
        // to convert word1[0..i-1] to word2[0..j-1]
        int [][] dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0) {
                    // If word1 is empty, insert all characters of word2
                    dp[i][j] = j;
                } else if(j == 0) {
                    // If word2 is empty, delete all characters of word1
                    dp[i][j] = i;
                } else if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    // Characters match, no operation needed
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // Characters do not match, consider all three operations:

                    // Insert: pretend we inserted word2[j-1] into word1
                    // so now match word1[0..i-1] with word2[0..j-2] + 1 operation
                    int insert = dp[i][j-1] + 1;

                    // Delete: pretend we deleted word1[i-1]
                    // so now match word1[0..i-2] with word2[0..j-1] + 1 operation
                    int delete = dp[i-1][j] + 1;

                    // Replace: pretend we replaced word1[i-1] with word2[j-1]
                    // so now match word1[0..i-2] with word2[0..j-2] + 1 operation
                    int replace = dp[i-1][j-1] + 1;

                    // Take the minimum of the three options
                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        return dp[m][n];
    }
}
