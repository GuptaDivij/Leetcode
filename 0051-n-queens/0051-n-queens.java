class Solution {
    private boolean[][] crossboard;
    private int n;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.crossboard = new boolean[n][n];
        this.n = n;
        this.res = new ArrayList<>();
        backtrack(0);
        return res;
    }

    public boolean canPlace(int row, int col){
        // check column
        for(int i = row-1; i>=0; i--){
            if(crossboard[i][col]) return false;
        }

        // left up diagonal 
        int i = row-1, j = col-1;
        while(i>=0 && j>=0){
            if(crossboard[i--][j--]) return false;
        }

        // right up diagonal
        i = row-1; 
        j = col+1;
        while(i>=0 && j<n){
            if(crossboard[i--][j++]) return false;
        }
        return true;
    }

    public void backtrack(int row){
        if(row==n){
            List<String> list = new ArrayList<>();
            for(int i = 0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j<n; j++){
                    if(crossboard[i][j]) sb.append('Q');
                    else sb.append('.');
                }
                list.add(sb.toString());
            }
            res.add(list);
        } 
        for(int col = 0; col<n; col++){
            if(canPlace(row, col)){
                crossboard[row][col] = true;
                backtrack(row+1);
                crossboard[row][col] = false;
            }
        }
    }
}
