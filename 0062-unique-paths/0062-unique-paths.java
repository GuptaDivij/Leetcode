class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];
        Arrays.fill(prevRow,1);
        for(int i = 1; i<m; i++){
            int [] newRow = new int[n];
            newRow[0]=1;
            for(int j = 1; j<n; j++){
                newRow[j]=newRow[j-1]+prevRow[j];
            }
            prevRow = newRow;
        }
        return prevRow[n-1];
    }
}