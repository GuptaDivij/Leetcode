class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLow = 0, rowHigh = matrix.length;
        int row = -1;
        while(rowLow<rowHigh){
            int midRow = (rowLow + rowHigh) / 2;
            if(matrix[midRow][0]<= target && matrix[midRow][matrix[0].length-1] >= target){
                row = midRow;
                break;
            }
            else if(matrix[midRow][matrix[0].length-1] > target){
                rowHigh = midRow;
            }
            else{
                rowLow = midRow+1;
            }
        }
        if(row==-1)return false;
        int low = 0, high = matrix[row].length;
        while(low<high){
            int mid = (low+high)/2;
            if(matrix[row][mid] == target)return true;
            else if(matrix[row][mid]>target) high = mid;
            else if(matrix[row][mid]<target) low = mid+1;
        }
        return false;
    }
}