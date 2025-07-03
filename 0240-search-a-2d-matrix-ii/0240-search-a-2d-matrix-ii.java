class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0;i<matrix.length;i++){
            if(matrix[i][0] > target) break;
            if(matrix[i][matrix[0].length-1] < target) continue;
            int low = 0, high = matrix[i].length;
            while(low<high){
                int mid = (low+high)/2;
                if(matrix[i][mid] == target)return true;
                else if(matrix[i][mid]>target) high = mid;
                else if(matrix[i][mid]<target) low = mid+1;
            }
        }
        return false;
    }
}