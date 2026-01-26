class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[]dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i<=n; i++){
            if(!dp[i-1]) continue;
            for (String word : wordDict) {
                int len = word.length();
                if (i - 1 + len > n) continue;
                if (word.equals(s.substring(i - 1, i - 1 + len))) {
                    dp[i - 1 + len] = true;
                }
            }
        }
        return dp[n];
    }
}