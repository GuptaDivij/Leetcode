class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[]dp = new boolean[s.length()+1];
        dp[0]=true;
        HashSet<String> words = new HashSet<>();
        HashSet<Integer> sizes = new HashSet<>();
        for(String word : wordDict){
            words.add(word);
            sizes.add(word.length());
        }
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) continue;
            for (int size : sizes) {
                int end = i + size;
                if (end <= s.length() && words.contains(s.substring(i, end))) {
                    dp[end] = true;
                }
            }
        }
        return dp[s.length()];
    }   
}