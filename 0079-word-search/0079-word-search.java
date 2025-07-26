class Solution {
    private boolean[][] taken;
    public boolean exist(char[][] board, String word) {
        if(board.length * board[0].length < word.length()) return false;
        taken = new boolean[board.length][board[0].length];

        for(int i = 0; i<board.length; i++){
            for(int j = 0;j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    taken[i][j] = true;
                    if(canMake(board, word, i, j, 1)) return true;
                    taken[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean canMake(char[][] board, String word, int row, int col, int idx){
        if(idx==word.length()){
            return true; 
        }
        // up
        boolean up = false;
        if(row-1>=0 && !taken[row-1][col] && board[row-1][col]==word.charAt(idx)) {
            taken[row-1][col]=true;
            up = canMake(board, word, row-1,col,idx+1);
            taken[row-1][col]=false;
        }

        // down
        boolean down = false;
        if(row+1<board.length && !taken[row+1][col] && board[row+1][col]==word.charAt(idx)) {
            taken[row+1][col]=true;
            down = canMake(board, word, row+1,col,idx+1);
            taken[row+1][col]=false;
        }

        // left
        boolean left = false;
        if(col-1>=0 && !taken[row][col-1] && board[row][col-1]==word.charAt(idx)) {
            taken[row][col-1]=true;
            left = canMake(board, word, row,col-1,idx+1);
            taken[row][col-1]=false;
        }

        // right
        boolean right = false;
        if(col+1<board[0].length && !taken[row][col+1] && board[row][col+1]==word.charAt(idx)) {
            taken[row][col+1]=true;
            right = canMake(board, word, row,col+1,idx+1);
            taken[row][col+1]=false;
        }
        return left || right || up || down;
    }
}