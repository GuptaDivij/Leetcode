class Solution {

    public int maxDiff(int num) {
        StringBuilder minNum = new StringBuilder(String.valueOf(num));
        StringBuilder maxNum = new StringBuilder(String.valueOf(num));

        for (int i = 0; i < maxNum.length(); ++i) {
            char digit = maxNum.charAt(i);
            if (digit != '9') {
                replace(maxNum, digit, '9');
                break;
            }
        }

        for (int i = 0; i < minNum.length(); ++i) {
            char digit = minNum.charAt(i);
            if (i == 0) {
                if (digit != '1') {
                    replace(minNum, digit, '1');
                    break;
                }
            } else {
                if (digit != '0' && digit != minNum.charAt(0)) {
                    replace(minNum, digit, '0');
                    break;
                }
            }
        }

        return Integer.parseInt(maxNum.toString()) - Integer.parseInt(minNum.toString());
    }

    public void replace(StringBuilder sb, char x, char y) {
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == x) {
                sb.setCharAt(i, y);
            }
        }
    }
}
