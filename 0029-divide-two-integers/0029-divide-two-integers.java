class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;

        // Use long to avoid overflow
        long lDividend = dividend;
        long lDivisor = divisor;

        int negative = 0;

        if (lDividend < 0) {
            negative++;
            lDividend = -lDividend;
        }

        if (lDivisor < 0) {
            negative++;
            lDivisor = -lDivisor;
        }

        int res = 0;
        while (lDividend >= lDivisor) {
            long tempDivisor = lDivisor;
            int multiple = 1;

            // Doubling until it exceeds
            while (lDividend >= tempDivisor + tempDivisor) {
                tempDivisor = tempDivisor + tempDivisor;
                multiple = multiple + multiple;
            }
            lDividend = lDividend - tempDivisor;
            res = res + multiple;
        }
        return (negative % 2 == 0) ? res : -res;
    }
}
