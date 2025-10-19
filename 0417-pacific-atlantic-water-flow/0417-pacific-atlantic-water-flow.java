class Solution {
    int [][] visited;
    int [][] visitA;
    int [][] visitP;
    int [][] heights;
    int [][] dirs;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        this.heights = heights;
        dirs = new int[][]{{-1,0}, {0,-1}, {0,1}, {1, 0}};
        visited = new int[m][n]; 
        visitA = new int[m][n]; // if i can traverse to ocean A
        visitP = new int[m][n]; // if i can traverse to ocean B
        for(int j = 0; j<n;j++){
            visitP[0][j] = 1;
        }
        for(int i = 0; i<m;i++){
            visitP[i][0] = 1;
        }
        for(int j = 0; j<n;j++){
            visitA[m-1][j] = 1;
        }
        for(int i = 0; i<m;i++){
            visitA[i][n-1] = 1;
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                visited = new int[m][n];
                dfs(i, j);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(visitA[i][j]==1 && visitP[i][j]==1){
                    List<Integer> currentPoint = new ArrayList<>();
                    currentPoint.add(i);
                    currentPoint.add(j);
                    res.add(currentPoint);
                }
            }
        }
        return res;
    }

    public void dfs(int i, int j){
        if(visited[i][j] != 0) return;
        visited[i][j] = 1;
        for(int[] dir : dirs){
            int row = i+dir[0];
            int col = j+dir[1];
            if(row>=0 && row<heights.length && col>=0 && col<heights[0].length){
                // if i can flow, I will call dfs
                if(heights[row][col] <= heights[i][j]){
                    dfs(row, col);
                    if(visitA[row][col]==1){
                        visitA[i][j] = 1;
                    }
                    if(visitP[row][col]==1){
                        visitP[i][j] = 1;
                    }
                }
            }
        }

        
    }
}