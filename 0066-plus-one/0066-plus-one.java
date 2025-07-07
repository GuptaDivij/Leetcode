class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1]!=9) {
            digits[digits.length-1] += 1;
            return digits;
        }
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            if (i == digits.length - 1) sum++;  
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if (carry == 0) return digits;
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}