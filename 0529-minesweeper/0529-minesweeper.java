class Solution {
    int[][] dirs = {
        {-1,0}, {1,0}, {0,-1}, {0,1},
        {-1,-1}, {-1,1}, {1,-1}, {1,1}
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];

        // Clicked on a mine
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            if (board[row][col] != 'E') continue;

            int count = countMines(board, row, col);

            if (count > 0) {
                board[row][col] = (char) (count + '0');
            } else {
                board[row][col] = 'B';
                for (int[] dir : dirs) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if (nr >= 0 && nr < board.length &&
                        nc >= 0 && nc < board[0].length &&
                        board[nr][nc] == 'E') {
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return board;
    }

    private int countMines(char[][] board, int row, int col) {
        int count = 0;
        for (int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if (nr >= 0 && nr < board.length &&
                nc >= 0 && nc < board[0].length &&
                board[nr][nc] == 'M') {
                count++;
            }
        }
        return count;
    }
}
