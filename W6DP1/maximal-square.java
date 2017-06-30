public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // max[i][j] is the max length of the current squre with bottom right at (i - 1,j - 1)
        int[][] max = new int[m + 1][n + 1]; 
        int res = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] != '0') {
                    max[i][j] = Math.min(max[i][j - 1], Math.min(max[i - 1][j], max[i - 1][j - 1])) + 1;
                    res = Math.max(res, max[i][j]);
                }
            }
        }
        return res * res;
    }
}
