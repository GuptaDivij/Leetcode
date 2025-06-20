public class Solution {

    public int maxDistance(String s, int k) {
        int latitude = 0, longitude = 0, ans = 0;
        int n = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c == 'N') {
                latitude++;
            } else if (c == 'S') {
                latitude--;
            } else if (c == 'E') {
                longitude++;
            } else if (c == 'W') {
                longitude--;
            }
            ans = Math.max(
                ans,
                Math.min(
                    Math.abs(latitude) + Math.abs(longitude) + k * 2,
                    i + 1
                )
            );
        }
        return ans;
    }
}
