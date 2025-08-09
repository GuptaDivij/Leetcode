class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        char lastSign = '+';
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr*10+(c-'0');
            }
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(lastSign=='+'){
                    stack.push(curr);
                }
                if(lastSign=='-'){
                    stack.push(-curr);
                }
                if(lastSign=='*'){
                    stack.push(stack.pop()*curr);
                }
                if(lastSign=='/'){
                    stack.push(stack.pop()/curr);
                }
                lastSign = c;
                curr=0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()) res+= stack.pop();
        return res;
    }
}