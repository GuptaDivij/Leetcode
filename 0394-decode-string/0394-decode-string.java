class Solution {
    public String decodeString(String s) {
        Stack<Integer> stackNum = new Stack<>();
        Stack<StringBuilder> stackChars = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) k = k * 10 + (ch - '0');
            else if (ch == '[') {
                stackNum.push(k);
                stackChars.push(currentStr);
                k = 0;
                currentStr = new StringBuilder();
            } else if (ch == ']') {
                int repeatTimes = stackNum.pop();
                StringBuilder previousStr = stackChars.pop();
                for (int i = 0; i < repeatTimes; i++) previousStr.append(currentStr);
                currentStr = previousStr;
            } else currentStr.append(ch);
        }
        return currentStr.toString();
    }
}
