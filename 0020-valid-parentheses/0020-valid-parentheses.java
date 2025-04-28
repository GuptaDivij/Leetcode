class Solution {
    public boolean isValid(String s) {
        if(s.length() %2 != 0){
            return false;
        }
        Stack<Character> open = new Stack<>();
        char [] str = s.toCharArray();
        for(char c: str){
            if(c == '(' || c == '{' || c=='['){
                open.push(c);
            }
            else{
                if(open.isEmpty()){
                    return false;
                }
                char last = open.pop();
                if(last == '(' && c!= ')'){
                    return false;
                }
                if(last == '[' && c!= ']'){
                    return false;
                }
                if(last == '{' && c!= '}'){
                    return false;
                }
            }
        }
        if (!open.isEmpty()){
            return false;
        }
        return true;
    }
}