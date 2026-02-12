class Solution {
    public int countPrimes(int n) {
        if (n == 0) return 0;
        
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        
        int count = 0;
        isPrime[0] = false;
        if (n > 1) isPrime[1] = false;
        
        for (int i = 0; i < n; i++) {
            if (isPrime[i]) {
                count++;
                int j = i * 2;
                while (j < n) {
                    isPrime[j] = false;
                    j = j + i;
                }
            }
        }
        
        return count;
    }
}