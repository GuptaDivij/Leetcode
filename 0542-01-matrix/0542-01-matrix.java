class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int limit = mat.length + mat[0].length;
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                if(mat[i][j]==0) continue;
                int top = i>0?mat[i-1][j]:limit;
                int left = j>0?mat[i][j-1]:limit;
                mat[i][j] = Math.min(top,left)+1;
            }
        }
        for(int i = mat.length-1; i>=0; i--){
            for(int j = mat[0].length-1; j>=0; j--){
                if(mat[i][j]==0) continue;
                int bottom = i<mat.length-1?mat[i+1][j]:limit;
                int right = j<mat[0].length-1?mat[i][j+1]:limit;
                mat[i][j] = Math.min(mat[i][j],Math.min(bottom,right)+1);
            }
        }
        return mat;
    }
}