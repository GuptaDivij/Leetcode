class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int i = 0, j = 0, idx = 0;
        boolean up = true;
        while (idx < m * n) {
            if (up) {
                while (i >= 0 && j < n) res[idx++] = mat[i--][j++];
                i++; j--; 
                up = false;
                if (j + 1 < n) j++;
                else i++;
            } else {
                while (i < m && j >= 0) res[idx++] = mat[i++][j--];
                i--; j++; 
                up = true;
                if (i + 1 < m) i++;
                else j++;
            }
        }
        return res;
    }
}
