class Solution {
    int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];
        int max = 1;
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length;j++){
                max=Math.max(max,helper(matrix, i, j));
            }
        }
        return max;

    }
    public int helper(int[][] matrix, int row, int col){
        if(memo[row][col]!=0) return memo[row][col];
        int max = 1;
        int curr = matrix[row][col];
        int up = (row>0 && matrix[row-1][col]>curr)?helper(matrix, row-1, col):0;
        int down = (row+1<matrix.length && matrix[row+1][col]>curr)?helper(matrix, row+1, col):0;
        int left = (col>0 && matrix[row][col-1]>curr)?helper(matrix, row, col-1):0;
        int right = (col+1<matrix[0].length && matrix[row][col+1]>curr)?helper(matrix, row, col+1):0;
        max = Math.max(max, 1 + Math.max(up, Math.max(down, Math.max(left, right))));
        memo[row][col] = max;
        return max;
    }
}