class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] tFreq = new int[128];
        int[] sFreq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            sFreq[c]++;
            while (contains(sFreq, tFreq)) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                sFreq[s.charAt(start)]--;
                start++;
            }
        }
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart + minLen);
    }

    private boolean contains(int[] sFreq, int[] tFreq) {
        for (int i = 0; i < 128; i++) {
            if (sFreq[i] < tFreq[i]) return false;
        }
        return true;
    }
}
