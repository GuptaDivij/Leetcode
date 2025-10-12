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
                if (s.charAt(i - 1) == '(') {
                    score += multiplier;
                }
            }
        }
        return score;
    }
}
