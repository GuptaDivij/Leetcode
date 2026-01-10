class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        Deque<int[]> queue = new ArrayDeque<>();
        int [][] costs = new int[n][m];
        for(int [] costRow : costs){
            Arrays.fill(costRow, Integer.MAX_VALUE);
        }
        costs[0][0] = 0;
        queue.offerFirst(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] curr = queue.pollFirst();
            int row = curr[0];
            int col = curr[1];
            for(int[]dir:dirs){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow<0 || newCol<0 || newRow >=n || newCol >=m) continue;
                int dirIndex = grid[row][col] - 1;
                int cost = (dirs[dirIndex][0] == dir[0] && dirs[dirIndex][1] == dir[1]) ? 0 : 1;
                int newCost = costs[row][col] + cost;
                if (newCost < costs[newRow][newCol]) {
                    costs[newRow][newCol] = newCost;
                    if (cost == 0) {
                        queue.offerFirst(new int[]{newRow, newCol});
                    } 
                    else {
                        queue.offerLast(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return costs[n-1][m-1];
    }
}