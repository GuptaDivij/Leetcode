class Solution {
    public int longestStrChain(String[] words) {
        if (words.length == 1) return 1;
        Arrays.sort(words, (a, b) -> a.length() - b.length()); // sort by length
        HashMap<String, Integer> dp = new HashMap<>(); // word -> max chain length
        int result = 1;
        
        // O(n * n * word)
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            int best = 1; // at least this word itself
            
            // O(n * word)
            for (int j = i - 1; j >= 0; j--) {
                if (words[j].length() < curr.length() - 1) break; 
                // O(word)
                if (words[j].length() == curr.length() - 1 && canBuild(curr, words[j])) {
                    best = Math.max(best, dp.get(words[j]) + 1);
                }
            }
            
            dp.put(curr, best);
            result = Math.max(result, best);
        }
        
        return result;
    }
    
    // check if "shorter" can become "longer" by adding exactly one character
    private boolean canBuild(String longer, String shorter) {
        if (longer.length() != shorter.length() + 1) return false;
        
        int i = 0, j = 0;
        boolean skipped = false;
        
        while (i < longer.length() && j < shorter.length()) {
            if (longer.charAt(i) == shorter.charAt(j)) {
                i++;
                j++;
            } else {
                if (skipped) return false; // already used our skip
                skipped = true;
                i++; // skip this char in longer
            }
        }
        
        return true; // valid if only one skip was needed
    }
}
