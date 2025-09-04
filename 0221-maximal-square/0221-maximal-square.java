class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] board = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j]-'0'==0)continue;
                int left = j>0?board[i][j-1]:0;
                int up = i>0?board[i-1][j]:0;
                int diag = j>0 && i>0?board[i-1][j-1]:0;
                board[i][j] = Math.min(left, Math.min(up, diag)) + 1;
                max = Math.max(max, board[i][j]);
            }
        }
        return max * max;
    }
}