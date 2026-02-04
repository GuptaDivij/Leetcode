class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==2) queue.offer(new int[]{i,j});
            }
        } 
        int minutes = 0;
        while(!queue.isEmpty()){
            int rotten = queue.size();
            int nw = 0;
            for(int i = 1; i<=rotten; i++){
                int [] rotting = queue.poll();
                for(int [] dir : dirs){
                    int row = rotting[0] + dir[0];
                    int col = rotting[1] + dir[1];
                    if(row<grid.length && col < grid[0].length && row>=0 && col >= 0 && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        queue.offer(new int[]{row,col});
                        nw++; 
                    }
                }
            }
            if(nw>0) minutes++;
        }
        return allRotten(grid)?minutes:-1;
    }
    public boolean allRotten(int[][] grid){
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j]==1) return false;
            }
        } 
        return true;
    }
}

// level order bfs