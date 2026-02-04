class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > (n + 1) / 2) return "";
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        char[] res = new char[n];
        int idx = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int ch = cur[0];
            int count = cur[1];
            while (count > 0) {
                if (idx >= n) idx = 1; 
                res[idx] = (char) (ch + 'a');
                idx += 2;
                count--;
            }
        }

        return new String(res);
    }
}
