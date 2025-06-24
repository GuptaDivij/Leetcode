class Solution {

    public long kMirror(int k, int n) {
       int left = 1, count = 0;
       long ans = 0;
       while(count<n){
        int right = left * 10;
        for (int op = 0; op < 2; ++op) {
            for (int i = left; i < right && count < n; ++i) {
                long combined = i;
                int x = (op == 0 ? i / 10 : i);
                while (x > 0) {
                    combined = combined * 10 + (x % 10);
                    x /= 10;
                }
                if (isPalindrome(combined, k)) {
                    ++count;
                    ans += combined;
                }
            }
        }
        left = right;
       }
       return ans;
    }

    public boolean isPalindrome(long x, int base){
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            sb.append((char) (x % base + '0'));
            x /= base;
        }
        String str = sb.toString();
        int start = 0, end = str.length()-1;
        while(start<end) if (str.charAt(start++)!=str.charAt(end--)) return false;
        return true;
    }

}