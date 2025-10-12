class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int multiplier = 1;  
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // going one level deeper
            if (c == '(') multiplier *= 2; 
            else {
                // update multiplier
                multiplier /= 2;  
                // if we just closed a "()", add current multiplier
                // ((( ))) in the most inside one we have multiplier = 4 we don't need other score.
                // If () if after this finishes, we need to start afresh with multiplier = 1
                // multiplier will never go below 1 as we know it is balanced
                if (s.charAt(i - 1) == '(') {
                    score += multiplier;
                }
            }
        }
        return score;
    }
}
