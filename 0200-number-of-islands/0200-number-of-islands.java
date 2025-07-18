class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = { {0,1}, {0,-1}, {1,0}, {-1,0} };
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int r = cell[0];
                        int c = cell[1];
                        for (int[] dir : directions) {
                            int newRow = r + dir[0];
                            int newCol = c + dir[1];
                            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == '1') {
                                queue.offer(new int[]{newRow, newCol});
                                grid[newRow][newCol] = '0';
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}
