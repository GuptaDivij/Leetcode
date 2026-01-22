class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(curr == ')' || curr == '}' || curr == ']') {
                if(stack.isEmpty()) return false;
                char last = stack.pop();
                if(curr == ')' && last != '(') return false;
                if(curr == ']' && last != '[') return false;
                if(curr == '}' && last != '{') return false;
            }
            else stack.push(curr);
        }
        return stack.isEmpty();
    }
}