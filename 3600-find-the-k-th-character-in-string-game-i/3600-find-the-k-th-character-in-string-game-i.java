class Solution {
    public char kthCharacter(int k) {
        int numOps = 32 - Integer.numberOfLeadingZeros(k); 
        StringBuilder word = new StringBuilder("a");
        for(int i = 1; i<=numOps; i++){
            word.append(nextWord(word));
        }
        return word.charAt(k-1);
    }
    public String nextWord (StringBuilder word){
        StringBuilder next = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'z') next.append('a');
            else next.append((char)(c + 1));
        }
        return next.toString();
    }
}