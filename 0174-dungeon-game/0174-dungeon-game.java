class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // dp - option is go tp right or down
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) dungeon[i][j] = Math.max(1, 1 - dungeon[i][j]);
                else if (i == m - 1) dungeon[i][j] = Math.max(1, dungeon[i][j + 1] - dungeon[i][j]);
                else if (j == n - 1) dungeon[i][j] = Math.max(1, dungeon[i + 1][j] - dungeon[i][j]);
                else {
                    int need = Math.min(dungeon[i][j + 1], dungeon[i + 1][j]);
                    dungeon[i][j] = Math.max(1, need - dungeon[i][j]);
                }
            }
        }
        return dungeon[0][0];
    }
}
