class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int count = 0;
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int countToMid = helper(matrix, low, mid);
            if (count + countToMid < k) {
                count += countToMid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int helper(int[][] matrix, int low, int mid) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] >= low && matrix[i][j] <= mid) {
                    res++;
                }
            }
        }
        return res;
    }
}
