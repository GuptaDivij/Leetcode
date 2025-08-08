class Solution {
    public int calculate(String s) {
        if(s.length()==1) return s.charAt(0)-'0';
        int calculated = 0, curr = 0, tail = 0;
        char lastOp = '+';
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) curr = curr*10 + (c-'0');
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(lastOp=='+'){
                    calculated += curr;
                    tail = curr; 
                }
                if(lastOp=='-'){
                    calculated -= curr;
                    tail = -curr;
                }
                if(lastOp=='*'){
                    calculated = calculated - tail + tail*curr;
                    tail = tail*curr;
                }
                if(lastOp=='/'){
                    calculated = calculated - tail + tail/curr;
                    tail = tail/curr;
                }
                curr=0;
                lastOp=c;
            }
        }
        return calculated;
    }
}

// 

// use lastSign seen, calculated, current, and tail. 