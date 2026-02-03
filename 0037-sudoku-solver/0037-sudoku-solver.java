class Solution {

    public void solveSudoku(char[][] board) {
        backTrack(board);
    }

    private boolean backTrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int candidate = 1; candidate <= 9; candidate++) {
                        if (canPlace(board, i, j, candidate)) {
                            board[i][j] = (char) ('0' + candidate);
                            if (backTrack(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false; 
                }
            }
        }
        return true; 
    }

    private boolean canPlace(char[][] board, int i, int j, int candidate) {
        // check row
        for (int col = 0; col < 9; col++) {
            if (board[i][col] - '0' == candidate) return false;
        }

        // check column
        for (int row = 0; row < 9; row++) {
            if (board[row][j] - '0' == candidate) return false;
        }

        // check 3x3 box
        int boxStartRow = (i / 3) * 3;
        int boxStartCol = (j / 3) * 3;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[boxStartRow + row][boxStartCol + col] - '0' == candidate)
                    return false;
            }
        }
        return true;
    }
}
