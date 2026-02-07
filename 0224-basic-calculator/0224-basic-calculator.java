class Solution {
    public int calculate(String s) {
        int res = 0;
        int curr = 0;
        int sign = 1;               
        Stack<Integer> stack = new Stack<>();
        stack.push(sign);              

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            } 
            else if (c == '+' || c == '-') {
                res += curr * sign;
                curr = 0;
                sign = (c == '+') ? stack.peek() : -stack.peek();
            } 
            else if (c == '(') {
                stack.push(sign);   
            } 
            else if (c == ')') {
                res += curr * sign;
                curr = 0;
                stack.pop();        
                sign = stack.peek();
            }
        }

        res += curr * sign;
        return res;
    }
}
