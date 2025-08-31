class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==0 || tokens == null) return 0;
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(token.equals("/") || token.equals("*") || token.equals("+") || token.equals("-")){
                int second = stack.pop(); 
                int first = stack.pop(); 
                int curr = 0;
                if(token.equals("/")) curr = first/second;
                else if(token.equals("*")) curr = first*second;
                else if(token.equals("+")) curr = first+second;
                else curr = first-second;
                stack.push(curr);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}