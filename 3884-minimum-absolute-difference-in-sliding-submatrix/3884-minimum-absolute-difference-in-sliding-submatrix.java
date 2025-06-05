class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int [][] ans = new int[grid.length-k+1][grid[0].length-k+1];
        for(int i = 0; i<grid.length-k+1; i++){
            for (int j = 0; j<grid[0].length-k+1; j++){
                ans[i][j] = minDiff(grid, i, i+k, j, j+k);
            }
        }
        return ans;
    }
    private int minDiff(int[][] grid, int i1, int i2, int j1, int j2){
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = i1; i < i2; i++) {
            for (int j = j1; j < j2; j++) {
                pq.add(grid[i][j]);
            }
        }
        if (pq.isEmpty()) return 0;
        int prev = pq.poll();
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek() == prev) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int curr = pq.peek();
                min = Math.min(min, curr - prev);
                prev = pq.poll();
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
