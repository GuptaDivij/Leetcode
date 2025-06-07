class Solution {
    public String robotWithString(String s) {
        StringBuilder ans = new StringBuilder();
        int [] charFreq = new int[26];
        for(char c : s.toCharArray()){
            charFreq[c-'a']++;
        }
        Stack<Character> stack = new Stack<>();
        char minChar = 'a';
        for(char c : s.toCharArray()){
            stack.push(c);
            charFreq[c-'a']--;
            while(minChar!='z' && charFreq[minChar-'a'] == 0){
                minChar++;
            }
            while(!stack.isEmpty() && stack.peek() <= minChar){
                ans.append(stack.pop());
            }
        }
        return ans.toString();
    }
}
