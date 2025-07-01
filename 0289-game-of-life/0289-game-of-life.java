class Solution {
    public void gameOfLife(int[][] board) {
        int [][]temp = new int[board.length][board[0].length];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                int up = i>0?board[i-1][j]:0;
                int down = i+1<board.length?board[i+1][j]:0;
                int left = j>0?board[i][j-1]:0;
                int right = j+1<board[0].length?board[i][j+1]:0;
                int upLeft = (j>0 && i>0)?board[i-1][j-1]:0;
                int upRight = (j+1<board[0].length && i>0)?board[i-1][j+1]:0;
                int downLeft = (j>0 && i+1<board.length)?board[i+1][j-1]:0;
                int downRight = (j+1<board[0].length && i+1<board.length)?board[i+1][j+1]:0;
                int score = up+down+left+right+upLeft+upRight+downLeft+downRight;
                if(score<2) temp[i][j] = 0;
                if(score>3) temp[i][j] = 0; 
                if(score==3) temp[i][j] = 1;
                if(score==2 && board[i][j]==1) temp[i][j]=1;
            }
        }
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                board[i][j] = temp[i][j];
            }
        }
    }
}