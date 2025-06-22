class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = (n + k - 1) / k; 
        String[] divided = new String[size];
        int idx = 0;
        for (int i = 0; i < n; i += k) {
            int end = Math.min(i + k, n);
            String curr = s.substring(i, end);
            while (curr.length() < k) {
                curr += fill;
            }
            divided[idx++] = curr;
        }
        return divided;
    }
}