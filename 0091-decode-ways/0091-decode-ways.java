class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        if(s.length()==1) return 1;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; 
        dp[1] = 1; 
        for (int i = 2; i <= n; i++) {
            char one = s.charAt(i - 1);
            char two = s.charAt(i - 2);
            if (one != '0') {
                dp[i] = dp[i - 1];
            }
            int num = (two - '0') * 10 + (one - '0');
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
        
    }
}

// if there is a zero, it has to be paired with its previous one.
// else if num is 1 or 2, and the next is in range to be 26, we can add one 