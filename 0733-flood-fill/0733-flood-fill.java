class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        if (image[r][c] != originalColor) {
            return;
        }
        image[r][c] = newColor;
        if (r >= 1) dfs(image, r - 1, c, originalColor, newColor); 
        if (c >= 1) dfs(image, r, c - 1, originalColor, newColor);
        if (r + 1 < image.length) dfs(image, r + 1, c, originalColor, newColor);
        if (c + 1 < image[0].length) dfs(image, r, c + 1, originalColor, newColor); 
    }
}
