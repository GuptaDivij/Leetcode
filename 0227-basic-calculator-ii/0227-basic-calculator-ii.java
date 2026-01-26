class Solution {
    public int calculate(String s) {
        int lastSum = 0;
        int lastNum = 0;
        int currNum = 0;
        char op = '+';  

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            }
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if (op == '+') {
                    lastSum += currNum;
                    lastNum = currNum;
                } else if (op == '-') {
                    lastSum -= currNum;
                    lastNum = -currNum;
                } else if (op == '*') {
                    lastSum = lastSum - lastNum + lastNum * currNum;
                    lastNum = lastNum * currNum;
                } else if (op == '/') {
                    lastSum = lastSum - lastNum + lastNum / currNum;
                    lastNum = lastNum / currNum;
                }
                op = c;
                currNum = 0;
            }
        }

        return lastSum;
    }
}
