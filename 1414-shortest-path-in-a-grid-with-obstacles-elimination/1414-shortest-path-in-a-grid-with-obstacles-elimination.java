// Space = O(n*m*k)
// Time = O(n*m*k)

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][k + 1];
        queue.add(new int[]{m-1,n-1,k});
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                size--;
                int[] current = queue.poll();
                if(visited[current[0]][current[1]][current[2]] ) continue;
                visited[current[0]][current[1]][current[2]] = true;
                if(current[0]==0 && current[1]==0){
                    return level;
                }
                if(current[0]-1>=0){
                    if(grid[current[0]-1][current[1]] == 1 && current[2]>0){
                        queue.add(new int[]{current[0]-1, current[1], current[2]-1});
                    }
                    else if (grid[current[0]-1][current[1]] != 1){
                        queue.add(new int[]{current[0]-1, current[1], current[2]});
                    }
                }
                if(current[1]-1>=0){
                    if(grid[current[0]][current[1]-1] == 1 && current[2]>0){
                        queue.add(new int[]{current[0], current[1]-1, current[2]-1});
                    }
                    else if(grid[current[0]][current[1]-1] != 1){
                        queue.add(new int[]{current[0], current[1]-1, current[2]});
                    }
                }
                if(current[0]+1<m){
                    if(grid[current[0]+1][current[1]] == 1 && current[2]>0){
                        queue.add(new int[]{current[0]+1, current[1], current[2]-1});
                    }
                    else if (grid[current[0]+1][current[1]] != 1){
                        queue.add(new int[]{current[0]+1, current[1], current[2]});
                    }
                }
                if(current[1]+1<n){
                    if(grid[current[0]][current[1]+1] == 1 && current[2]>0){
                        queue.add(new int[]{current[0], current[1]+1, current[2]-1});
                    }
                    else if(grid[current[0]][current[1]+1] != 1) { 
                        queue.add(new int[]{current[0], current[1]+1, current[2]});
                    }
                }
            }
            level++;
        }
        return -1;
    }
}