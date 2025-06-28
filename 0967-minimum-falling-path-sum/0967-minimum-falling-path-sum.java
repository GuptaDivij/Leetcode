class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        if(n==1) for(int i = 0; i<n; i++) res = Math.min(res, matrix[0][i]);
        for(int i = n-2; i>=0; i--){
            for(int j = 0; j<n; j++){
                int down = matrix[i+1][j];
                int leftDiag = j-1>=0?matrix[i+1][j-1]:Integer.MAX_VALUE;
                int rightDiag = j+1<n?matrix[i+1][j+1]:Integer.MAX_VALUE;
                matrix[i][j] = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
                if(i==0) res = Math.min(res, matrix[i][j]);
            }
        }
        return res;
    }
}

// start from second last row LOL