class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0, down = m - 1;
        int left = 0, right = n - 1;
        List<Integer> res = new ArrayList<>();
        
        while (res.size() < m * n) {
            // right
            for (int j = left; j <= right && res.size() < m * n; j++) {
                res.add(matrix[up][j]);
            }
            up++;

            // down
            for (int i = up; i <= down && res.size() < m * n; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // left
            for (int j = right; j >= left && res.size() < m * n; j--) {
                res.add(matrix[down][j]);
            }
            down--;

            // up
            for (int i = down; i >= up && res.size() < m * n; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
