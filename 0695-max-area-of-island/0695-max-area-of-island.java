class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i,j});
                    while(!queue.isEmpty()){
                        int[] point = queue.poll();
                        if(point[0]>=0 && point[0]<grid.length && point[1]>=0 && point[1]<grid[0].length && grid[point[0]][point[1]] == 1) {
                            grid[point[0]][point[1]]=0;
                            area++;
                            for(int idx = 0; idx<directions.length; idx++){
                                queue.offer(new int[] {point[0]+directions[idx][0], point[1]+directions[idx][1]});
                            }
                        }
                    }
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}