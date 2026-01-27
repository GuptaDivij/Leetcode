class Solution {
    int[][] dirs;
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            if (board[row][col] == 'M') { 
                board[row][col] = 'X';
            }
            else{
                int count = countMines(board, row, col);
                if (count > 0) { 
                    board[row][col] = (char)(count + '0');
                }
                else {
                    board[row][col] = 'B';
                    for(int[] dir : dirs){
                        int nr = row + dir[0];
                        int nc = col + dir[1];
                        if(nr<board.length && nc<board[0].length && nr>=0 && nc>=0 && board[nr][nc]=='E'){
                            queue.offer(new int[]{nr, nc});
                            board[nr][nc] = 'B';
                        }
                    }
                }
            }
        }
        return board;
    }
    public int countMines(char[][] board, int row, int col){
        int ct = 0;
        for(int[] dir : dirs){
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr<board.length && nc<board[0].length && nr>=0 && nc>=0 && board[nr][nc]=='M'){
                ct++;
            }
        }
        return ct;
    }
}